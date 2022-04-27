package xyz.pavelkorolev.brainpan.splash.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import xyz.pavelkorolev.brainpan.splash.view.SplashFragment

/**
 * Splash Screen navigation description
 */
val SplashScreenDescriptor = FragmentScreen("splash") {
    SplashFragment.newInstance()
}
