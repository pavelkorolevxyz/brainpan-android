package xyz.pavelkorolev.brainpan.addnote.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository

interface AddNoteFeatureDeps {

    val router: Router
    val noteRepository: NoteRepository

    interface DepsProvider {
        fun provideAddNoteFeatureDeps(): AddNoteFeatureDeps
    }
}
