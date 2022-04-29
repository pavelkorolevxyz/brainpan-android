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
    plugins.register("android.app.signing") {
        id = "android.app.signing"
        implementationClass = "AndroidAppSigningPlugin"
    }
}
