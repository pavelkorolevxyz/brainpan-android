package xyz.pavelkorolev.brainpan.settings.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolev.brainpan.settings.view.SettingsViewModel
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelFactoryModule
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelKey

@Module(
    includes = [
        ViewModelFactoryModule::class,
    ],
)
internal interface SettingsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun bindViewModel(viewModel: SettingsViewModel): ViewModel
}
