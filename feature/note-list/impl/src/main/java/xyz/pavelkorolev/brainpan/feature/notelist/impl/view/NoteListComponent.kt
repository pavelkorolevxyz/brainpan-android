package xyz.pavelkorolev.brainpan.feature.notelist.impl.view

import androidx.lifecycle.ViewModelProvider
import dagger.Component

@Component(
    modules = [
        NoteListModule::class,
    ],
    dependencies = [
        NoteListFeatureDeps::class,
    ],
)
internal interface NoteListComponent {

    val viewModelFactory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(deps: NoteListFeatureDeps): NoteListComponent
    }
}
