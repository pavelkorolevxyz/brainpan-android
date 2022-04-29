package xyz.pavelkorolev.brainpan.settings.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.data.observer.AddNoteEventObserver

interface SettingsFeatureDeps {

    val router: Router
    val noteRepository: NoteRepository

    interface DepsProvider {
        fun provideSettingsFeatureDeps(): SettingsFeatureDeps
    }
}
