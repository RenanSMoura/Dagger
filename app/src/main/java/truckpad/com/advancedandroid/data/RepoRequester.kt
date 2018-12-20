package truckpad.com.advancedandroid.data

import io.reactivex.Single
import truckpad.com.advancedandroid.models.Repo
import javax.inject.Inject

class RepoRequester @Inject constructor(var service: RepoService) {

    fun getTrendingRepos() : Single<List<Repo>> {
        return service.getTrendingRepos().map {
            it.repos
        }
    }



}