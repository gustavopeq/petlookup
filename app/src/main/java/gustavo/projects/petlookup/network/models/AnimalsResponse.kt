package gustavo.projects.petlookup.network.models

import com.google.gson.annotations.SerializedName

data class AnimalsResponse(
    @SerializedName("animals")
    var animals: List<Animals>
)
