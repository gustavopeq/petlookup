package gustavo.projects.petlookup.network.models.content

import com.google.gson.annotations.SerializedName
import gustavo.projects.petlookup.models.Animals
import gustavo.projects.petlookup.network.models.common.Pagination

data class AnimalsResponse(
    @SerializedName("animals")
    var animals: List<Animals>,
    @SerializedName("pagination")
    var pagination: Pagination
)
