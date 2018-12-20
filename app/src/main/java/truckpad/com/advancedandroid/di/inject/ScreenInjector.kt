package truckpad.com.advancedandroid.di.inject

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import dagger.android.AndroidInjector
import truckpad.com.advancedandroid.base.BaseActivity
import truckpad.com.advancedandroid.base.BaseController
import truckpad.com.advancedandroid.di.scope.ActivityScope
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider


@ActivityScope
class ScreenInjector @Inject
constructor(private val screenInjectors: Map<Class<out Controller>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Controller>>>) {
    private val cache = HashMap<String?, AndroidInjector<Controller>>()


    fun inject(controller: Controller) {
        if (controller !is BaseController) {
            throw IllegalArgumentException("Controller must extend BaseController")
        }

        val instanceId = controller.instanceId
        if (cache.containsKey(instanceId)) {
            cache[instanceId]?.inject(controller)
            return
        }


        val injectorFactory = screenInjectors[controller.javaClass]?.get() as AndroidInjector.Factory<Controller>
        val injector = injectorFactory.create(controller)
        cache[instanceId] = injector
        injector.inject(controller)
    }

    fun clear(controller: Controller) {
        cache.remove(controller.instanceId)
    }

    companion object {
        fun get(activity: Activity): ScreenInjector {
            return (activity as BaseActivity).screenInjector
        }
    }
}