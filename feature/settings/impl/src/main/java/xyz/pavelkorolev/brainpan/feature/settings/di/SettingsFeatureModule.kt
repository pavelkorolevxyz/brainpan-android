package xyz.pavelkorolev.brainpan.feature.settings.di

import dagger.Binds
import dagger.Module
import xyz.pavelkorolev.brainpan.feature.settings.api.SettingsFeatureApi

@Module
interface SettingsFeatureModule {

    @Binds
    fun bindApi(impl: SettingsFeatureApiImpl): SettingsFeatureApi
}
