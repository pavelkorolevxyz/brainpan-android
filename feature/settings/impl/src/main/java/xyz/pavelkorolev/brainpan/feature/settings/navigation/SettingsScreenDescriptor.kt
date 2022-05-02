package xyz.pavelkorolev.brainpan.feature.settings.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import xyz.pavelkorolev.brainpan.feature.settings.view.SettingsFragment

/**
 * Settings Screen navigation description
 */
fun createSettingsScreen() = FragmentScreen("settings") {
    SettingsFragment.newInstance()
}
