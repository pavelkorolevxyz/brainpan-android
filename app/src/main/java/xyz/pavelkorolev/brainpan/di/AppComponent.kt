package xyz.pavelkorolev.brainpan.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import xyz.pavelkorolev.brainpan.app.AppActivityDeps

@DatabaseScope
@NavigationScope
@Component(
    modules = [
        NavigationModule::class,
        DatabaseModule::class,
    ],
)
internal interface AppComponent : AppActivityDeps {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
        ): AppComponent
    }
}
