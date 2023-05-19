package gustavo.projects.petlookup.network

import gustavo.projects.petlookup.network.models.content.AnimalsResponse
import gustavo.projects.petlookup.network.models.auth.UserTokenRequest
import gustavo.projects.petlookup.network.models.auth.UserTokenResponse
import gustavo.projects.petlookup.network.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.TOKEN_URL)
    suspend fun getToken(@Body request: UserTokenRequest): Response<UserTokenResponse>

    @GET(Constants.ANIMALS_URL)
    suspend fun fetchAnimals(): Response<AnimalsResponse>
}