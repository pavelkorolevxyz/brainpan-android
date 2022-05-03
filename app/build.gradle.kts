plugins {
    id("convention.android.app")
    id("convention.android.app.signing")
    id("convention.detekt")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {

    defaultConfig {
        applicationId = "xyz.pavelkorolev.brainpan"

        versionCode = 2
        versionName = "0.2.0"

        resourceConfigurations += setOf("en")
    }

    signingConfigs {
        getByName("debug") {
            signWithProperties(rootProject.file("keystore-debug.properties"))
        }
        create("release") {
            signWithProperties(rootProject.file("keystore.properties"))
        }
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

            signingConfig = signingConfigs.getByName("release")
        }
    }
}

dependencies {
    implementation(projects.core.analytics)
    implementation(projects.core.crash)
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.observer)
    implementation(projects.core.ui)
    implementation(projects.core.utils)
    implementation(projects.feature.addNote.api)
    implementation(projects.feature.addNote.impl)
    implementation(projects.feature.settings.api)
    implementation(projects.feature.settings.impl)
    implementation(projects.feature.splash.api)
    implementation(projects.feature.splash.impl)
    implementation(projects.feature.noteList.api)
    implementation(projects.feature.noteList.impl)

    implementation(libs.androidx.fragment)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.cicerone)
}
