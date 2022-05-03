package xyz.pavelkorolev.brainpan.core.analytics

import android.util.Log

/**
 * Reporter which logs events to LogCat.
 */
class LogAnalyticsReporter : AnalyticsReporter {

    override fun logEvent(event: String, params: Map<String, Any?>) {
        Log.i(TAG, "Logging analytics event: $event, params: $params")
    }

    private companion object {
        private const val TAG = "Analytics"
    }
}
