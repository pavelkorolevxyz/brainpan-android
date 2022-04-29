package xyz.pavelkorolev.brainpan.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import xyz.pavelkorolev.brainpan.core.data.api.DatabaseProvider
import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.data.observer.AddNoteEventObserver
import xyz.pavelkorolev.brainpan.core.data.repository.DatabaseNoteRepository
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseScope

@Module(
    includes = [
        DatabaseBindsModule::class,
    ],
)
class DatabaseModule {

    @DatabaseScope
    @Provides
    fun provideDatabaseProvider(
        application: Application,
    ): DatabaseProvider = DatabaseProvider(application)

    @DatabaseScope
    @Provides
    fun provideAddNoteEventObserver(): AddNoteEventObserver = AddNoteEventObserver()
}

@Module
interface DatabaseBindsModule {

    @Binds
    fun bindNoteRepository(impl: DatabaseNoteRepository): NoteRepository
}
