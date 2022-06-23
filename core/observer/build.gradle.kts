import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("convention.android.library")
    id("convention.detekt")
}

tasks.withType(KotlinCompile::class).all {
    kotlinOptions.freeCompilerArgs += listOf(
        "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.FlowPreview",
    )
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
