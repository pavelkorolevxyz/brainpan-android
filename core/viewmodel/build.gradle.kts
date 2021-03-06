plugins {
    id("convention.android.library")
    id("convention.detekt")
    id("kotlin-kapt")
}

dependencies {
    implementation(libs.androidx.fragment)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}
