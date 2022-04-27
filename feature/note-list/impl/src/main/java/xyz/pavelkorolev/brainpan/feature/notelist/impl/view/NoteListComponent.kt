package xyz.pavelkorolev.brainpan.feature.notelist.impl.view

import dagger.Component
import xyz.pavelkorolev.brainpan.core.viewmodel.ViewModelFactory

@Component(
    modules = [
        NoteListModule::class,
    ],
    dependencies = [
        NoteListFeatureDeps::class,
    ],
)
internal interface NoteListComponent {

    val viewModelFactory: ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(deps: NoteListFeatureDeps): NoteListComponent
    }
}
