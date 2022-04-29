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

gradlePlugin {
    plugins.register("convention.android.app.signing") {
        id = "convention.android.app.signing"
        implementationClass = "AndroidAppSigningPlugin"
    }
}
