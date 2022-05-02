package xyz.pavelkorolev.brainpan.app.di

import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Component
import xyz.pavelkorolev.brainpan.app.AppActivityDeps
import xyz.pavelkorolev.brainpan.feature.addnote.di.AddNoteFeatureDeps
import xyz.pavelkorolev.brainpan.feature.addnote.di.AddNoteFeatureModule
import xyz.pavelkorolev.brainpan.feature.notelist.impl.di.NoteListFeatureModule
import xyz.pavelkorolev.brainpan.feature.notelist.impl.view.NoteListFeatureDeps
import xyz.pavelkorolev.brainpan.feature.settings.di.SettingsFeatureDeps
import xyz.pavelkorolev.brainpan.feature.settings.di.SettingsFeatureModule
import xyz.pavelkorolev.brainpan.feature.splash.api.SplashFeatureApi
import xyz.pavelkorolev.brainpan.feature.splash.di.SplashFeatureDeps
import xyz.pavelkorolev.brainpan.feature.splash.di.SplashFeatureModule

@Component(
    modules = [
        SplashFeatureModule::class,
        NoteListFeatureModule::class,
        AddNoteFeatureModule::class,
        SettingsFeatureModule::class,
    ],
    dependencies = [AppActivityDeps::class],
)
internal interface AppActivityComponent :
    AddNoteFeatureDeps,
    NoteListFeatureDeps,
    SettingsFeatureDeps,
    SplashFeatureDeps {

    val navigatorHolder: NavigatorHolder
    val splashFeatureApi: SplashFeatureApi

    @Component.Factory
    interface Factory {
        fun create(deps: AppActivityDeps): AppActivityComponent
    }
}
