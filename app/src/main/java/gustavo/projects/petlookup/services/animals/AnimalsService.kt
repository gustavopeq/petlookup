package gustavo.projects.petlookup.services.animals

import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.content.AnimalsResponse

interface AnimalsService {
    suspend fun fetchAnimals(): SimpleResponse<AnimalsResponse>
}