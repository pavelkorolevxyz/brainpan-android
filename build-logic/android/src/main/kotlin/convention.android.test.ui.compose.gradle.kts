import org.gradle.accessors.dm.LibrariesForLibs
import utils.androidTestImplementation

val libs = the<LibrariesForLibs>()

plugins {
    id("convention.android.test.ui")
}

dependencies {
    androidTestImplementation(libs.androidx.compose.uiTest)

    androidTestImplementation(libs.kaspresso.compose)
}
