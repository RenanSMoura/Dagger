package truckpad.com.advancedandroid.home

import com.bluelinelabs.conductor.Controller
import truckpad.com.advancedandroid.R
import truckpad.com.advancedandroid.base.BaseActivity
import truckpad.com.advancedandroid.trending.TrendingReposController

class MainActivity : BaseActivity() {

    override fun initialScreen(): Controller {
        return TrendingReposController()
    }

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }
}
