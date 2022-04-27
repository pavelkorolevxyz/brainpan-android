package xyz.pavelkorolev.brainpan.feature.notelist.impl.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import xyz.pavelkorolev.brainpan.core.compose.fragmentComposeView
import xyz.pavelkorolev.brainpan.core.extensions.lazyFast
import xyz.pavelkorolev.brainpan.feature.addnote.api.AddNoteFeatureApi

interface NoteListFeatureDeps {

    val addNoteFeatureApi: AddNoteFeatureApi

    interface DepsProvider {
        fun provideNoteListFeatureDeps(): NoteListFeatureDeps
    }
}

class NoteListFragment : Fragment() {

    private val component: NoteListComponent by lazyFast {
        val deps = (activity as NoteListFeatureDeps.DepsProvider).provideNoteListFeatureDeps()
        DaggerNoteListComponent.factory().create(deps)
    }

    private val viewModelFactory by lazyFast { component.viewModelFactory }

    private val viewModel: NoteListViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = fragmentComposeView {
        NoteListScreen(
            state = viewModel.viewState,
            onHeaderClick = { viewModel.onHeaderClick() },
            onAddClick = { viewModel.onAddClick() },
        )
    }
}
