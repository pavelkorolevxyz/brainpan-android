package xyz.pavelkorolev.brainpan.core.analytics

/**
 * An analytics reporter interface
 */
interface AnalyticsReporter {

    fun logEvent(event: String, params: Map<String, Any?>)
}
