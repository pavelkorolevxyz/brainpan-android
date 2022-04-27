package xyz.pavelkorolev.brainpan.addnote.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        AddNoteFeatureDeps::class,
    ],
)
interface AddNoteFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
            dependencies: AddNoteFeatureDeps,
        ): AddNoteFeatureComponent
    }
}
