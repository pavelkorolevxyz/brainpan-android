package xyz.pavelkorolev.brainpan.feature.settings.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import xyz.pavelkorolev.brainpan.core.compose.fragmentInsetsComposeView
import xyz.pavelkorolev.brainpan.core.extensions.lazyFast
import xyz.pavelkorolev.brainpan.core.ui.BaseFragment
import xyz.pavelkorolev.brainpan.feature.settings.di.DaggerSettingsComponent
import xyz.pavelkorolev.brainpan.feature.settings.di.SettingsComponent
import xyz.pavelkorolev.brainpan.feature.settings.di.SettingsFeatureDeps
import kotlin.reflect.KProperty

class SettingsFragment : BaseFragment() {

    private val component: SettingsComponent by lazyFast {
        val provider = activity as SettingsFeatureDeps.DepsProvider
        DaggerSettingsComponent.factory()
            .create(this, provider.provideSettingsFeatureDeps())
    }

    private val viewModel: SettingsViewModel by viewModels { component.viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = fragmentInsetsComposeView {
        SettingsScreen(
            onBackClick = viewModel::onBackClick,
            onExportClick = viewModel::onExportClick,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.jsonShareEvents.collect(::shareText)
        }
    }

    private fun shareText(text: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }
        startActivity(sendIntent)
    }

    companion object {
        fun newInstance(): Fragment = SettingsFragment()
    }
}

class FragmentExitDelegate {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}
