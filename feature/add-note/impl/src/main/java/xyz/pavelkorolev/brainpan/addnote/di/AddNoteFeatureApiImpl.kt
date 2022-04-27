package xyz.pavelkorolev.brainpan.addnote.di

import com.github.terrakok.cicerone.Router
import xyz.pavelkorolev.brainpan.addnote.navigation.createAddNoteScreen
import xyz.pavelkorolev.brainpan.feature.addnote.api.AddNoteFeatureApi
import javax.inject.Inject

/**
 * Implementation of Add Note feature API.
 */
class AddNoteFeatureApiImpl @Inject constructor(
    private val router: Router,
) : AddNoteFeatureApi {

    override fun navigateAddNote() {
        router.navigateTo(createAddNoteScreen())
    }
}
