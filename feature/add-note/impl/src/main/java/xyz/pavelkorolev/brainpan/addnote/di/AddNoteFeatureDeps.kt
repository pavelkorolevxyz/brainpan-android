package xyz.pavelkorolev.brainpan.addnote.di

interface AddNoteFeatureDeps {

    interface DepsProvider {
        fun provideAddNoteFeatureDeps(): AddNoteFeatureDeps
    }
}
