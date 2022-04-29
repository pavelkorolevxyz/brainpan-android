plugins {
    id("convention.android.library")
    id("convention.detekt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.kotlinx.serialization)
    implementation(libs.inject)
}
