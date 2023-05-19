package gustavo.projects.petlookup.network.models.common

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("previous")
    var previous: Href?,
    @SerializedName("next")
    var next: Href?
)
