package gustavo.projects.petlookup.models

import com.google.gson.annotations.SerializedName

data class Breeds(
    @SerializedName("primary")
    var primary: String?,
    @SerializedName("secondary")
    var secondary: String?,
    @SerializedName("mixed")
    var mixed: Boolean?,
)
