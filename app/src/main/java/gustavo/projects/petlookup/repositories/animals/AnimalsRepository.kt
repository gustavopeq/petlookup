package gustavo.projects.petlookup.repositories.animals

import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.content.AnimalsResponse

interface AnimalsRepository {
    suspend fun fetchAnimals(): SimpleResponse<AnimalsResponse>
}