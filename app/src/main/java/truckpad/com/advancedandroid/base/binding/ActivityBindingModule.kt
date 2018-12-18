package truckpad.com.advancedandroid.base.binding

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import truckpad.com.advancedandroid.di.components.MainActivityComponent
import truckpad.com.advancedandroid.home.MainActivity


@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
     abstract fun provideMainActivityInjector(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}