plugins {
    id("convention.android.app")
    id("convention.android.app.signing")
    id("convention.detekt")
    id("kotlin-kapt")
}

android {

    defaultConfig {
        applicationId = "xyz.pavelkorolevxyz.brainpan"

        versionCode = 1
        versionName = "0.1.0"
    }

    signingConfigs {
        getByName("debug")
        create("release") {
            val keystorePropertiesFile = rootProject.file("keystore.properties")

            val signingConfig = loadSigningConfig(keystorePropertiesFile)
                ?: loadSigningConfigFromEnvironment()
                ?: return@create

            storeFile = keystorePropertiesFile.parentFile.resolve(signingConfig.keystoreFile)
            storePassword = signingConfig.password
            keyAlias = signingConfig.alias
            keyPassword = signingConfig.aliasPassword
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
