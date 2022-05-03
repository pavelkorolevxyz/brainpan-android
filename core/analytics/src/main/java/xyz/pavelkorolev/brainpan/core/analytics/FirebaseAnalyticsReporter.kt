package xyz.pavelkorolev.brainpan.core.analytics

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

/**
 * Reporter which logs events to Firebase Analytics.
 */
class FirebaseAnalyticsReporter(
    application: Application,
) : AnalyticsReporter {

    private val firebaseAnalytics = FirebaseAnalytics.getInstance(application)

    override fun logEvent(event: String, params: Map<String, Any?>) {
        val bundle = Bundle(params.size).apply {
            for ((key, value) in params) {
                putString(key, value?.toString())
            }
        }
        firebaseAnalytics.logEvent(event, bundle)
    }
}
