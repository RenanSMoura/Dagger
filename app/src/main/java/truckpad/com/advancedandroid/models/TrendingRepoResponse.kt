package truckpad.com.advancedandroid.models

import com.google.gson.annotations.SerializedName

data class TrendingRepoResponse(@SerializedName("items") var repos: List<Repo>)