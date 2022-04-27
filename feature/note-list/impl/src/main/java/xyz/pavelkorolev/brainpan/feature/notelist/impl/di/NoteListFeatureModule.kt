package xyz.pavelkorolev.brainpan.feature.notelist.impl.di

import dagger.Binds
import dagger.Module
import xyz.pavelkorolev.brainpan.feature.notelist.api.NoteListFeatureApi

@Module
interface NoteListFeatureModule {

    @Binds
    fun bindApi(impl: NoteListFeatureApiImpl): NoteListFeatureApi
}
