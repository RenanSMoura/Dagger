package truckpad.com.advancedandroid.base

import dagger.Component
import dagger.Provides
import truckpad.com.advancedandroid.base.binding.ActivityBindingModule
import truckpad.com.advancedandroid.data.RepoServiceModule
import truckpad.com.advancedandroid.networking.ServiceModule
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class,
    ActivityBindingModule::class,
    ServiceModule::class,
    RepoServiceModule::class])
interface ApplicationComponent {
    fun inject(mainApplication: MainApplication)
}