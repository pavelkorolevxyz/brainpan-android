package xyz.pavelkorolev.brainpan.addnote.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import xyz.pavelkorolev.brainpan.core.compose.fragmentComposeView

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = fragmentComposeView {
        WorkInProgressScreen()
    }

    companion object {
        fun newInstance() = AddFragment()
    }
}
