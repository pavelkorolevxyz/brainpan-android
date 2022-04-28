plugins {
    id("convention.android.library")
    id("convention.detekt")
    id("kotlin-kapt")
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.core.utils)
    implementation(projects.feature.splash.api)
    implementation(projects.feature.noteList.api)

    implementation(libs.androidx.fragment)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.cicerone)
}
