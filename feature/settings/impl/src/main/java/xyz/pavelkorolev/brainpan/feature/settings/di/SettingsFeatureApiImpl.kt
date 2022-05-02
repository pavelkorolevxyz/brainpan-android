package xyz.pavelkorolev.brainpan.feature.settings.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.feature.settings.api.SettingsFeatureApi
import xyz.pavelkorolev.brainpan.feature.settings.navigation.createSettingsScreen
import javax.inject.Inject

/**
 * Implementation of Settings feature API.
 */
class SettingsFeatureApiImpl @Inject constructor(
    private val router: Router,
) : SettingsFeatureApi {

    override fun navigateSettings() {
        router.navigateTo(createSettingsScreen())
    }
}
