package truckpad.com.advancedandroid.data

import io.reactivex.Single
import retrofit2.http.GET
import truckpad.com.advancedandroid.models.Repo
import truckpad.com.advancedandroid.models.TrendingRepoResponse

interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=starts")
    fun getTrendingRepos() : Single<TrendingRepoResponse>
}