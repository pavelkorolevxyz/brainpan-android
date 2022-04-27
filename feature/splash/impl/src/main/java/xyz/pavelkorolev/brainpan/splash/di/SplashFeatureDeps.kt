package xyz.pavelkorolev.brainpan.splash.di

import xyz.pavelkorolev.brainpan.feature.notelist.api.NoteListFeatureApi

interface SplashFeatureDeps {

    val noteListFeatureApi: NoteListFeatureApi

    interface DepsProvider {
        fun provideSplashFeatureDeps(): SplashFeatureDeps
    }
}
