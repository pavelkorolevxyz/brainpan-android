package xyz.pavelkorolev.brainpan.settings.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import xyz.pavelkorolev.brainpan.settings.view.SettingsFragment

/**
 * Settings Screen navigation description
 */
fun createSettingsScreen() = FragmentScreen("settings") {
    SettingsFragment.newInstance()
}
