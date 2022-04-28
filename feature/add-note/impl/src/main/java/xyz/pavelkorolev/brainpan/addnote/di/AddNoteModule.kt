package xyz.pavelkorolev.brainpan.addnote.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolev.brainpan.addnote.view.AddNoteViewModel
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelKey
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelFactoryModule

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
