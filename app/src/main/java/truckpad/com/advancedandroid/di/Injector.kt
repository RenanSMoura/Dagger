package truckpad.com.advancedandroid.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import truckpad.com.advancedandroid.di.inject.ActivityInjector
import truckpad.com.advancedandroid.di.inject.ScreenInjector

class Injector {

    companion object {
        fun inject(activity: Activity) {
            ActivityInjector.get(activity).inject(activity)
        }

        fun cleanComponent(activity: Activity) {
            ActivityInjector.get(activity).clean(activity)
        }

        fun inject(controller : Controller) {
            ScreenInjector.get(controller.activity!!).inject(controller)

        }
        fun clearController(controller: Controller){
            ScreenInjector.get(controller.activity!!).clear(controller)
        }
    }
}