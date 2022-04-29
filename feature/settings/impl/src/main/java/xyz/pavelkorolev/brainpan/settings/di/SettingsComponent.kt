package xyz.pavelkorolev.brainpan.settings.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        SettingsModule::class,
    ],
    dependencies = [
        SettingsFeatureDeps::class,
    ],
)
internal interface SettingsComponent {

    val viewModelFactory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
            dependencies: SettingsFeatureDeps,
        ): SettingsComponent
    }
}
