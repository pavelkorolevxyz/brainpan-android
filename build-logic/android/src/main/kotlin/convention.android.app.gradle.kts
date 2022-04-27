@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("convention.android.base")
    id("kotlin-android")
}

android {
    lint {
        checkReleaseBuilds = false
        checkDependencies = true
    }
}
