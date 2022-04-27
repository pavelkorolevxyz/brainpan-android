@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("convention.android.base")
    id("kotlin-android")
}

android {
    lint {
        checkReleaseBuilds = false
    }
}
