plugins {
    id("convention.android.app")
    id("convention.detekt")
    id("kotlin-kapt")
}

android {

    defaultConfig {
        applicationId = "xyz.pavelkorolevxyz.brainpan"

        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"

            isShrinkResources = false
            isMinifyEnabled = false
        }
        release {
            isShrinkResources = true
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    implementation(projects.core.utils)
    implementation(projects.feature.addNote.api)
    implementation(projects.feature.addNote.impl)
    implementation(projects.feature.splash.api)
    implementation(projects.feature.splash.impl)
    implementation(projects.feature.noteList.api)
    implementation(projects.feature.noteList.impl)

    implementation(libs.androidx.fragment)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.cicerone)
}
