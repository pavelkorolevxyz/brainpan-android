package xyz.pavelkorolev.brainpan.addnote.di

import com.github.terrakok.cicerone.Router

interface AddNoteFeatureDeps {

    val router: Router

    interface DepsProvider {
        fun provideAddNoteFeatureDeps(): AddNoteFeatureDeps
    }
}
