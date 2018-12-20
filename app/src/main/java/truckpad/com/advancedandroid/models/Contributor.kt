package truckpad.com.advancedandroid.models

import com.google.gson.annotations.SerializedName


data class Contributor(
    var id: Long = 0,

    var login: String = "",

    @SerializedName("avatar_url")
    var avatarUrl: String = ""
)