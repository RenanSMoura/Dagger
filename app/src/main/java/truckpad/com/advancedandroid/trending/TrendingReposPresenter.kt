package truckpad.com.advancedandroid.trending

import truckpad.com.advancedandroid.data.RepoRequester
import truckpad.com.advancedandroid.di.scope.ScreenScope
import javax.inject.Inject


@ScreenScope
class TrendingReposPresenter
        @Inject constructor(var viewModel: TrendingReposViewModel, var repoRequester: RepoRequester){

    init {
        loadRepos()
    }

    private fun loadRepos() {
        repoRequester.getTrendingRepos()
            .doOnSubscribe {
             viewModel.loadingUpdated().accept(true)
            }.doOnEvent { _, _ ->
                viewModel.loadingUpdated().accept(false)
            }.subscribe(
                viewModel.reposUpdated(),
                viewModel.onError())
    }

}