package xyz.pavelkorolev.brainpan.splash.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import xyz.pavelkorolev.brainpan.feature.notelist.api.NoteListFeatureApi

@Component(
    dependencies = [
        SplashFeatureDeps::class,
    ],
)
interface SplashFeatureComponent {

    val noteListFeatureApi: NoteListFeatureApi

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
            dependencies: SplashFeatureDeps,
        ): SplashFeatureComponent
    }
}
