plugins {
    base
    id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

buildscript {
    dependencies {
        classpath(libs.kotlinGradle)
    }
}
