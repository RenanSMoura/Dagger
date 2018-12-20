package truckpad.com.advancedandroid.trending

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import timber.log.Timber
import truckpad.com.advancedandroid.R
import truckpad.com.advancedandroid.di.scope.ScreenScope
import truckpad.com.advancedandroid.models.Repo
import javax.inject.Inject


@ScreenScope
class TrendingReposViewModel @Inject constructor() {

    private val reposRelay = BehaviorRelay.create<List<Repo>>()
    private val errorRelay = BehaviorRelay.create<Int>()
    private val loadingRelay = BehaviorRelay.create<Boolean>()



    fun loading() : Observable<Boolean> {
        return loadingRelay
    }

    fun repos() : Observable<List<Repo>> {
        return reposRelay
    }

    fun error() : Observable<Int> {
        return errorRelay
    }

    fun loadingUpdated() : Consumer<Boolean> {
        return loadingRelay
    }

    fun reposUpdated() : Consumer<List<Repo>> {
        errorRelay.accept(-1)
        return reposRelay
    }

    fun onError() : Consumer<Throwable> {
        return Consumer {
            Timber.e(it,"Error loading Repos")
            errorRelay.accept(R.string.api_error)
        }
    }



}