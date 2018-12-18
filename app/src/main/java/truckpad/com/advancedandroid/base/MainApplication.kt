package truckpad.com.advancedandroid.base

import android.app.Application
import truckpad.com.advancedandroid.di.inject.ActivityInjector
import javax.inject.Inject

class MainApplication : Application() {


    @Inject lateinit var activityInjector : ActivityInjector
    private lateinit var  component : ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
        component.inject(this)
    }


}