plugins {
    id("convention.android.library")
    id("convention.detekt")
}

dependencies {
    implementation(libs.androidx.fragment)
    implementation(libs.dagger)
}
