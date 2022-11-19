plugins {
    `kotlin-dsl`
}

group = "buildlogic"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.kotlinGradle)
    implementation(libs.androidGradle)

    // Workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
