package gustavo.projects.petlookup.network.models

import com.google.gson.annotations.SerializedName

data class Animals(
    @SerializedName("id")
    var id: Int,
    @SerializedName("url")
    var url: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("age")
    var age: String?,
    @SerializedName("gender")
    var gender: String?
)
