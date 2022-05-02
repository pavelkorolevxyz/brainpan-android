package xyz.pavelkorolev.brainpan.feature.addnote.di

import dagger.Binds
import dagger.Module
import xyz.pavelkorolev.brainpan.feature.addnote.api.AddNoteFeatureApi

@Module
interface AddNoteFeatureModule {

    @Binds
    fun bindApi(impl: AddNoteFeatureApiImpl): AddNoteFeatureApi
}
