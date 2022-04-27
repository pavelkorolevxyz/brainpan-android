package xyz.pavelkorolev.brainpan

import android.app.Application
import xyz.pavelkorolev.brainpan.app.AppActivityDeps
import xyz.pavelkorolev.brainpan.di.AppComponent
import xyz.pavelkorolev.brainpan.di.DaggerAppComponent

/**
 * Application entry point.
 */
class App :
    Application(),
    AppActivityDeps.DepsProvider {

    private val component: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun provideAppActivityDeps(): AppActivityDeps = component
}
