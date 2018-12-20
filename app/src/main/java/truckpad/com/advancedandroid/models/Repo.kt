package truckpad.com.advancedandroid.models

import com.google.gson.annotations.SerializedName
data class Repo(
    var id: Long = 0,

    var name: String = "",

    var description: String = "",

    var owner: User = User(),

    @SerializedName("stargazers_count")
    var stargazersCount: Long = 0,

    @SerializedName("forks_count")
    var forksCount: Long = 0,

    @SerializedName("contributors_url")
    var contributorsUrl: String = "",

    @SerializedName("created_at")
    var createdAt: String = "",

    @SerializedName("updated_at")
    var updatedAt: String = ""
)