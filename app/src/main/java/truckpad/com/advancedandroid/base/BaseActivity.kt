package truckpad.com.advancedandroid.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import truckpad.com.advancedandroid.R
import truckpad.com.advancedandroid.di.Injector
import truckpad.com.advancedandroid.di.inject.ScreenInjector
import java.lang.NullPointerException
import java.util.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject lateinit var screenInjector : ScreenInjector
    private val INSTANCE_ID_KEY = "instance_id"

    private lateinit var router : Router
    var instanceId : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = if (savedInstanceState != null){
            savedInstanceState.getString(INSTANCE_ID_KEY)
        } else {
            UUID.randomUUID().toString()
        }

        Injector.inject(this)
        setContentView(layoutRes())
        val screenContainer  =
            findViewById<ConstraintLayout>(R.id.screen_container) ?:
            throw  NullPointerException("Activity must have a view with id : Screen_container")

        router = Conductor.attachRouter(this,screenContainer,savedInstanceState)
        monitorBackStack()
        super.onCreate(savedInstanceState)
    }

    private fun monitorBackStack() {
        router.addChangeListener(object : ControllerChangeHandler.ControllerChangeListener{
            override fun onChangeStarted(
                to: Controller?,
                from: Controller?,
                isPush: Boolean,
                container: ViewGroup,
                handler: ControllerChangeHandler
            ) {

            }

            override fun onChangeCompleted(
                to: Controller?,
                from: Controller?,
                isPush: Boolean,
                container: ViewGroup,
                handler: ControllerChangeHandler
            ) {
              if (!isPush && from != null) {
                  Injector.clearController(from)
              }
            }

        })
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(INSTANCE_ID_KEY,instanceId)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            Injector.cleanComponent(this)
        }
    }

    @LayoutRes
     abstract fun layoutRes(): Int

}