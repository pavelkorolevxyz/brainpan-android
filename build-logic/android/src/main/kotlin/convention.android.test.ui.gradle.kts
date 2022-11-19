import com.android.build.gradle.BaseExtension
import org.gradle.accessors.dm.LibrariesForLibs
import utils.androidTestImplementation
import utils.androidTestUtil

val libs = the<LibrariesForLibs>()

configure<BaseExtension> {
    defaultConfig {
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
    }
    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"

        animationsDisabled = true
    }
}

dependencies {
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.ext)

    androidTestImplementation(libs.kaspresso)

    androidTestUtil(libs.androidx.test.orchestrator)
}
