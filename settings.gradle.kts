@file:Suppress("UnstableApiUsage")

include(":app")
include(":core:compose")
include(":core:data")
include(":core:exporter")
include(":core:model")
include(":core:observer")
include(":core:ui")
include(":core:utils")
include(":core:viewmodel")
include(":feature:add-note:api")
include(":feature:add-note:impl")
include(":feature:settings:api")
include(":feature:settings:impl")
include(":feature:splash:api")
include(":feature:splash:impl")
include(":feature:note-list:api")
include(":feature:note-list:impl")

includeBuild("build-logic")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "brainpan-android"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}
