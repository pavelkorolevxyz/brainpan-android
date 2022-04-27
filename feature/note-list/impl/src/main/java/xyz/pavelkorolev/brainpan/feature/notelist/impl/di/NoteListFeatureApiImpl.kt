package xyz.pavelkorolev.brainpan.feature.notelist.impl.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.feature.notelist.api.NoteListFeatureApi
import xyz.pavelkorolev.brainpan.feature.notelist.impl.navigation.createNoteListScreen
import javax.inject.Inject

class NoteListFeatureApiImpl @Inject constructor(
    private val router: Router,
) : NoteListFeatureApi {

    override fun replaceNoteList() {
        router.replaceScreen(createNoteListScreen())
    }
}
