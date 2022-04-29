plugins {
    base
    id("io.gitlab.arturbosch.detekt").version("1.20.0")
}

buildscript {
    dependencies {
        classpath(libs.kotlinGradle)
    }
}
