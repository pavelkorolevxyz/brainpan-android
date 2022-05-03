package xyz.pavelkorolev.brainpan.core.analytics

/**
 * An entry point for analytics.
 */
class Analytics(
    private val reporters: List<AnalyticsReporter>,
) {

    /**
     * Reports an event.
     */
    fun logEvent(
        event: String,
        params: Map<String, Any?> = emptyMap(),
    ) {
        for (reporter in reporters) {
            reporter.logEvent(event, params)
        }
    }
}
