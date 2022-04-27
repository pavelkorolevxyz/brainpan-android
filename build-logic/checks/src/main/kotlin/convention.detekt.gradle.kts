import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.report.ReportMergeTask

plugins {
    base
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.19.0")
}

val configFile = files("$rootDir/config/detekt/config.yml")
val baselineFile = file("config/detekt/baseline.xml")
val mergedReportFile = file("${rootProject.buildDir}/reports/detekt/report.xml")
val xmlReportFile = file("$buildDir/reports/detekt/report.xml")

detekt {
    ignoreFailures = false

    parallel = true

    config.setFrom(configFile)
    buildUponDefaultConfig = true

    baseline = baselineFile
}

val reportMerge by tasks.registering(ReportMergeTask::class) {
    description = "Runs merge of all detekt reports into single one"
    output.set(mergedReportFile)
}

tasks.withType(Detekt::class).configureEach {
    reports {
        html.required.set(false)
        sarif.required.set(false)
        txt.required.set(false)
        xml.required.set(true)
        xml.outputLocation.set(xmlReportFile)
    }
}

plugins.withType(DetektPlugin::class) {
    tasks.withType(Detekt::class) {
        finalizedBy(reportMerge)
        reportMerge.configure {
            input.from(xmlReportFile)
        }
    }
}
