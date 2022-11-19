@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.BaseExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the
import utils.implementation

val libs = the<LibrariesForLibs>()

configure<BaseExtension> {

    with(buildFeatures) {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.androidx.compose.runtime)
}
