package truckpad.com.advancedandroid.di.components

import dagger.Subcomponent
import dagger.android.AndroidInjector
import truckpad.com.advancedandroid.di.scope.ScreenScope
import truckpad.com.advancedandroid.home.trending.TrendingReposController


@ScreenScope
@Subcomponent
interface TrendingReposComponent  : AndroidInjector<TrendingReposController>{
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TrendingReposController>(){
        override fun seedInstance(instance: TrendingReposController?) {

        }
    }
}