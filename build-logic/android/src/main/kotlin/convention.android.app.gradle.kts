@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("convention.android.base")
    id("kotlin-android")
}

val lintConfigFile = file("$rootDir/config/lint/config.yml")

android {
    lint {
        checkReleaseBuilds = false
        checkDependencies = true

        lintConfig = lintConfigFile
    }
}
