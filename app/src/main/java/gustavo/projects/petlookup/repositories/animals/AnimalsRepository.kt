package gustavo.projects.petlookup.repositories.animals

import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.AnimalsResponse

interface AnimalsRepository {
    suspend fun fetchAnimals(): SimpleResponse<AnimalsResponse>
}