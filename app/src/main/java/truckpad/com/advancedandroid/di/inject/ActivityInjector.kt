package truckpad.com.advancedandroid.di.inject

import android.app.Activity
import android.content.Context
import dagger.android.AndroidInjector
import truckpad.com.advancedandroid.base.BaseActivity
import truckpad.com.advancedandroid.base.MainApplication

import javax.inject.Inject
import javax.inject.Provider
import java.util.HashMap

class ActivityInjector @Inject
constructor(private val activityInjectors: Map<Class<out Activity>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Activity>>>) {
    private val cache = HashMap<String?, AndroidInjector<Activity>>()
    private var instanceId: String? = null

    fun inject(activity: Activity) {
        if (activity !is BaseActivity) {
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }

        instanceId = activity.instanceId

        if (cache.containsKey(instanceId)) {
            (cache[instanceId] as AndroidInjector<Activity>).inject(activity)
            return
        }

        @Suppress("UNCHECKED_CAST")
        val injectorFactory = activityInjectors[activity.javaClass]?.get() as AndroidInjector.Factory<Activity>
        val injector = injectorFactory.create(activity)
        cache[instanceId] = injector
        injector.inject(activity)
    }

    fun clean(activity: Activity) {
        if (activity !is BaseActivity) {
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }
        cache.remove(activity.instanceId)
    }

    companion object {
        fun get(context: Context): ActivityInjector {
            return (context.applicationContext as MainApplication).activityInjector
        }
    }


}
