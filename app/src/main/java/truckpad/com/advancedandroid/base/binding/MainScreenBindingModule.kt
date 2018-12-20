package truckpad.com.advancedandroid.base.binding

import com.bluelinelabs.conductor.Controller
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import truckpad.com.advancedandroid.di.ControllerKey
import truckpad.com.advancedandroid.di.components.TrendingReposComponent
import truckpad.com.advancedandroid.trending.TrendingReposController


@Module(subcomponents = [TrendingReposComponent::class])
abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController::class)
     abstract fun bindingTrendingReposInjector(builder: TrendingReposComponent.Builder): AndroidInjector.Factory<out Controller>
}