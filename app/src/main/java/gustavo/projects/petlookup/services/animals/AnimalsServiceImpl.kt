package gustavo.projects.petlookup.services.animals

import gustavo.projects.petlookup.network.ApiService
import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.content.AnimalsResponse
import gustavo.projects.petlookup.network.utils.safeApiCall
import javax.inject.Inject

class AnimalsServiceImpl @Inject constructor(
    private val apiService: ApiService
): AnimalsService {
    override suspend fun fetchAnimals(): SimpleResponse<AnimalsResponse> {
        return safeApiCall { apiService.fetchAnimals() }
    }
}