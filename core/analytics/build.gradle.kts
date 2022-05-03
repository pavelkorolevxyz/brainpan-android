plugins {
    id("convention.android.library")
    id("convention.detekt")
    id("com.google.gms.google-services")
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
}
