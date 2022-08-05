plugins {
    id("convention.android.library")
    id("convention.detekt")
    id("com.google.firebase.crashlytics") // Should be declared in all app modules which use crash reporting
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
}
