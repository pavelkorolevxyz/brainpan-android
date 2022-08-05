plugins {
    id("com.android.application") version "7.2.2" apply false
    id("com.android.library") version "7.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.0" apply false
    id("io.gitlab.arturbosch.detekt") version "1.21.0" apply false
    id("com.google.gms.google-services") version "4.3.13" apply false
    id("com.google.firebase.crashlytics") version "2.9.1" apply false
    id("com.github.ben-manes.versions") version "0.42.0"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// https://github.com/ben-manes/gradle-versions-plugin
tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
