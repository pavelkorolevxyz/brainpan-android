@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.BaseExtension

configure<BaseExtension> {
    compileSdkVersion(33)

    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }

    with(buildFeatures) {
        buildConfig = false
    }
}
