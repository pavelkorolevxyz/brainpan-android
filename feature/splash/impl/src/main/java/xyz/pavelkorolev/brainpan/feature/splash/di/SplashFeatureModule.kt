package xyz.pavelkorolev.brainpan.feature.splash.di

import dagger.Binds
import dagger.Module
import xyz.pavelkorolev.brainpan.feature.splash.api.SplashFeatureApi

@Module
interface SplashFeatureModule {

    @Binds
    fun bindApi(impl: SplashFeatureApiImpl): SplashFeatureApi
}
