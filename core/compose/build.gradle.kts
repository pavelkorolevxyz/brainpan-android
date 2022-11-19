plugins {
    id("convention.android.library")
    id("convention.detekt")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.androidx.fragment)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.uiToolingPreview)
    debugImplementation(libs.androidx.compose.uiTooling)
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.systemUiController)
    implementation(libs.accompanist.insetsUi)
}
