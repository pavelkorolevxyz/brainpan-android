package xyz.pavelkorolev.brainpan.feature.splash.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import xyz.pavelkorolev.brainpan.core.extensions.lazyFast
import xyz.pavelkorolev.brainpan.core.ui.BaseFragment
import xyz.pavelkorolev.brainpan.feature.splash.di.DaggerSplashFeatureComponent
import xyz.pavelkorolev.brainpan.feature.splash.di.SplashFeatureComponent
import xyz.pavelkorolev.brainpan.feature.splash.di.SplashFeatureDeps
import xyz.pavelkorolev.brainpan.feature.splash.impl.R

/**
 * Splash Screen UI
 */
class SplashFragment : BaseFragment(R.layout.splash_fragment) {

    private val component: SplashFeatureComponent by lazyFast {
        val provider = activity as SplashFeatureDeps.DepsProvider
        DaggerSplashFeatureComponent.factory()
            .create(
                this,
                provider.provideSplashFeatureDeps(),
            )
    }

    private val noteListFeatureApi by lazyFast { component.noteListFeatureApi }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).post {
            noteListFeatureApi.replaceNoteList()
        }
    }

    companion object {
        fun newInstance(): Fragment = SplashFragment()
    }
}
