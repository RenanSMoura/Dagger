package truckpad.com.advancedandroid.ui

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
 abstract class NavigationModule {

    @Binds
    abstract fun provideScreenNavigator(screenNavigator: DefaultScreenNavigator) : ScreenNavigator
}