package gustavo.projects.petlookup.repositories.animals

import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.AnimalsResponse
import gustavo.projects.petlookup.services.animals.AnimalsService
import javax.inject.Inject

class AnimalsRepositoryImpl @Inject constructor(
    private val animalsService: AnimalsService
) : AnimalsRepository {
    override suspend fun fetchAnimals(): SimpleResponse<AnimalsResponse> {
        return animalsService.fetchAnimals()
    }
}