plugins {
    id("convention.android.library")
    id("convention.android.compose")
    id("convention.detekt")
    id("kotlin-kapt")
}

dependencies {
    implementation(projects.core.compose)
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.observer)
    implementation(projects.core.resources)
    implementation(projects.core.ui)
    implementation(projects.core.utils)
    implementation(projects.core.viewmodel)
    implementation(projects.feature.addNote.api)

    implementation(libs.androidx.fragment)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.uiToolingPreview)
    debugImplementation(libs.androidx.compose.uiTooling)
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.systemUiController)
    implementation(libs.accompanist.insetsUi)
    coreLibraryDesugaring(libs.android.desugar)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.cicerone)
}
