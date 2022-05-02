package xyz.pavelkorolev.brainpan.feature.settings.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository

interface SettingsFeatureDeps {

    val router: Router
    val noteRepository: NoteRepository

    interface DepsProvider {
        fun provideSettingsFeatureDeps(): SettingsFeatureDeps
    }
}
