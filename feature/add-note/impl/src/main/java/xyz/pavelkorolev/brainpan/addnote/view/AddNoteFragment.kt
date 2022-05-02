package xyz.pavelkorolev.brainpan.addnote.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import xyz.pavelkorolev.brainpan.addnote.di.AddNoteComponent
import xyz.pavelkorolev.brainpan.addnote.di.AddNoteFeatureDeps
import xyz.pavelkorolev.brainpan.addnote.di.DaggerAddNoteComponent
import xyz.pavelkorolev.brainpan.core.compose.fragmentInsetsComposeView
import xyz.pavelkorolev.brainpan.core.extensions.lazyFast
import xyz.pavelkorolev.brainpan.core.ui.BaseFragment

class AddNoteFragment : BaseFragment() {

    private val component: AddNoteComponent by lazyFast {
        val provider = activity as AddNoteFeatureDeps.DepsProvider
        DaggerAddNoteComponent.factory()
            .create(this, provider.provideAddNoteFeatureDeps())
    }

    private val viewModel: AddNoteViewModel by viewModels { component.viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = fragmentInsetsComposeView {
        AddNoteScreen(
            noteText = viewModel.text,
            onBackClick = {
                viewModel.onBackClick()
            },
            onTextChange = viewModel::onTextChange,
            onSaveClick = {
                viewModel.onSaveClick()
            },
        )
    }

    companion object {
        fun newInstance(): Fragment = AddNoteFragment()
    }
}
