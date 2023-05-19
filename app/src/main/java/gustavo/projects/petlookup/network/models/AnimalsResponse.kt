package gustavo.projects.petlookup.network.models

import com.google.gson.annotations.SerializedName
import gustavo.projects.petlookup.models.Animals

data class AnimalsResponse(
    @SerializedName("animals")
    var animals: List<Animals>
)
