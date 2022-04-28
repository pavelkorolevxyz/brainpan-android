package xyz.pavelkorolev.brainpan.feature.notelist.impl.view

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelKey
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelFactoryModule

@Module(
    includes = [
        ViewModelFactoryModule::class,
    ],
)
interface NoteListModule {

    @Binds
    @IntoMap
    @ViewModelKey(NoteListViewModel::class)
    fun bindViewModel(viewModel: NoteListViewModel): ViewModel
}
