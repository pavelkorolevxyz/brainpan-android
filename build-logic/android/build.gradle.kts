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
}
