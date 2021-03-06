plugins {
    `kotlin-dsl`
}

group = "buildlogic"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.detektGradle)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
