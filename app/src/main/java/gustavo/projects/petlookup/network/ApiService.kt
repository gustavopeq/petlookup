package gustavo.projects.petlookup.network

import gustavo.projects.petlookup.network.models.AnimalsResponse
import gustavo.projects.petlookup.network.models.UserTokenRequest
import gustavo.projects.petlookup.network.models.UserTokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.TOKEN_URL)
    fun getToken(@Body request: UserTokenRequest): Call<UserTokenResponse>

    @GET(Constants.ANIMALS_URL)
    fun fetchAnimals(): Call<AnimalsResponse>
}