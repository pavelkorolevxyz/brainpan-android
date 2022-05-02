package xyz.pavelkorolev.brainpan.feature.addnote.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelFactoryModule
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelKey
import xyz.pavelkorolev.brainpan.feature.addnote.view.AddNoteViewModel

@Module(
    includes = [
        ViewModelFactoryModule::class,
    ],
)
internal interface AddNoteModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddNoteViewModel::class)
    fun bindViewModel(viewModel: AddNoteViewModel): ViewModel
}
