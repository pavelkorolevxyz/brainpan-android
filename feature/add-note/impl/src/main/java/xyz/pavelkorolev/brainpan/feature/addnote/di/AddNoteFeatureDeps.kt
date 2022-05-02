package xyz.pavelkorolev.brainpan.feature.addnote.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.data.observer.AddNoteEventObserver

interface AddNoteFeatureDeps {

    val router: Router
    val noteRepository: NoteRepository
    val addNoteEventObserver: AddNoteEventObserver

    interface DepsProvider {
        fun provideAddNoteFeatureDeps(): AddNoteFeatureDeps
    }
}
