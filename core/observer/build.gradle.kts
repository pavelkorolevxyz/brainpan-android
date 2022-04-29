import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("convention.android.library")
    id("convention.detekt")
}

tasks.withType(KotlinCompile::class).all {
    kotlinOptions.freeCompilerArgs += listOf(
        "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.FlowPreview",
    )
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
