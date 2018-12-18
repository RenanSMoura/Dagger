package truckpad.com.advancedandroid.di.components

import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import truckpad.com.advancedandroid.base.binding.MainScreenBindingModule
import truckpad.com.advancedandroid.di.scope.ActivityScope
import truckpad.com.advancedandroid.home.MainActivity


@ActivityScope
@Subcomponent(modules = [MainScreenBindingModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>(){
        override fun seedInstance(instance: MainActivity?) {

        }
    }
}