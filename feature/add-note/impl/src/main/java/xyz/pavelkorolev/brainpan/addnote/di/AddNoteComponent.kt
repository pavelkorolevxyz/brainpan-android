package xyz.pavelkorolev.brainpan.addnote.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AddNoteModule::class,
    ],
    dependencies = [
        AddNoteFeatureDeps::class,
    ],
)
internal interface AddNoteComponent {

    val viewModelFactory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
            dependencies: AddNoteFeatureDeps,
        ): AddNoteComponent
    }
}
