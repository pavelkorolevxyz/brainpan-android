package xyz.pavelkorolev.brainpan.splash.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.feature.splash.api.SplashFeatureApi
import xyz.pavelkorolev.brainpan.splash.navigation.SplashScreenDescriptor
import javax.inject.Inject

/**
 * Implementation of Splash feature external API
 */
class SplashFeatureApiImpl @Inject constructor(
    private val router: Router
) : SplashFeatureApi {

    override fun setRootSplash() {
        router.newRootScreen(SplashScreenDescriptor)
    }
}
