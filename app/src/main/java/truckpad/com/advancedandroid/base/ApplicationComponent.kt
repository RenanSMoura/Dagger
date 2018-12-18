package truckpad.com.advancedandroid.base

import dagger.Component
import dagger.Provides
import truckpad.com.advancedandroid.base.binding.ActivityBindingModule
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class, ActivityBindingModule::class])
interface ApplicationComponent {
    fun inject(mainApplication: MainApplication)
}