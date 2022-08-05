plugins {
    id("convention.android.library")
    id("convention.detekt")
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
}
