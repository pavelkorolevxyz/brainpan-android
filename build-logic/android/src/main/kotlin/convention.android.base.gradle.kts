@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.BaseExtension

configure<BaseExtension> {
    compileSdkVersion(32)

    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }

    with(buildFeatures) {
        buildConfig = false
    }
}
