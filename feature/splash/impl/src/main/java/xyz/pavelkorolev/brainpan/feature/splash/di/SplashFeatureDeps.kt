package xyz.pavelkorolev.brainpan.feature.splash.di

import xyz.pavelkorolev.brainpan.feature.notelist.api.NoteListFeatureApi

interface SplashFeatureDeps {

    val noteListFeatureApi: NoteListFeatureApi

    interface DepsProvider {
        fun provideSplashFeatureDeps(): SplashFeatureDeps
    }
}
