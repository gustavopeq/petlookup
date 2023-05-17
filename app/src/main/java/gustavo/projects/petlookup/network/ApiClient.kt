package gustavo.projects.petlookup.network

import gustavo.projects.petlookup.network.models.UserTokenRequest
import gustavo.projects.petlookup.network.models.UserTokenResponse
import retrofit2.Response

class ApiClient(
    private val apiService: ApiService
) {

    suspend fun getToken(userTokenRequest: UserTokenRequest): SimpleResponse<UserTokenResponse> {
        return safeApiCall { apiService.getToken(userTokenRequest) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>) : SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        }catch (e: Exception){
            SimpleResponse.failure(e)
        }
    }
}