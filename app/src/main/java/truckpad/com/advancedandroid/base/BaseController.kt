package truckpad.com.advancedandroid.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import truckpad.com.advancedandroid.di.Injector

abstract class BaseController : Controller(){



    private val disposables = CompositeDisposable()
    private var injected = false
    override fun onContextAvailable(context: Context) {
        if (!injected) {
            Injector.inject(this)
            injected = true
        }
        super.onContextAvailable(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(layoutRes(),container,false)
        disposables.addAll(subscription()[0])
        return view
    }

    override fun onDestroyView(view: View) {
        disposables.clear()
    }

    protected fun onViewBound(view : View) {

    }

    protected fun subscription(): Array<Disposable> {
        return arrayOf()
    }

    @LayoutRes
    protected abstract fun layoutRes() : Int
}
