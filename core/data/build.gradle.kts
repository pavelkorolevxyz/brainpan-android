plugins {
    id("convention.android.library")
    id("convention.detekt")
    id("kotlin-kapt")
}

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.observer)

    implementation(libs.inject)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.androidx.room)
    kapt(libs.androidx.room.compiler)
}
