package xyz.pavelkorolev.brainpan.app

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import xyz.pavelkorolev.brainpan.app.di.DaggerAppActivityComponent
import xyz.pavelkorolev.brainpan.core.extensions.lazyFast
import xyz.pavelkorolev.brainpan.feature.notelist.impl.view.NoteListFeatureDeps
import xyz.pavelkorolev.brainpan.feature.splash.api.SplashFeatureApi
import xyz.pavelkorolev.brainpan.splash.di.SplashFeatureDeps

interface AppActivityDeps {

    val navigatorHolder: NavigatorHolder
    val router: Router

    interface DepsProvider {
        fun provideAppActivityDeps(): AppActivityDeps
    }
}

/**
 * Main activity of the app.
 */
class AppActivity :
    FragmentActivity(),
    SplashFeatureDeps.DepsProvider,
    NoteListFeatureDeps.DepsProvider {

    private val component by lazyFast {
        val provider = application as AppActivityDeps.DepsProvider
        DaggerAppActivityComponent.factory().create(provider.provideAppActivityDeps())
    }

    private val navigatorHolder: NavigatorHolder by lazyFast { component.navigatorHolder }
    private val splashFeatureApi: SplashFeatureApi by lazyFast { component.splashFeatureApi }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) return
        WindowCompat.setDecorFitsSystemWindows(window, false)

        splashFeatureApi.setRootSplash()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(
            AppNavigator(this, android.R.id.content),
        )
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun provideSplashFeatureDeps(): SplashFeatureDeps = component

    override fun provideNoteListFeatureDeps(): NoteListFeatureDeps = component
}
