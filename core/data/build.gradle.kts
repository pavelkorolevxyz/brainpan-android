plugins {
    id("convention.android.library")
    id("convention.detekt")
    id("kotlin-kapt")
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.inject)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.androidx.room)
    kapt(libs.androidx.room.compiler)
}
