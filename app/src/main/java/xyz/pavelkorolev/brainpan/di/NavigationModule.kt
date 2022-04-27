package xyz.pavelkorolev.brainpan.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NavigationScope

@Module
class NavigationModule {

    @NavigationScope
    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @NavigationScope
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @NavigationScope
    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()
}
