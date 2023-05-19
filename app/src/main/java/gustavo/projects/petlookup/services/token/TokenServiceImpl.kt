package gustavo.projects.petlookup.services.token

import gustavo.projects.petlookup.network.ApiService
import gustavo.projects.petlookup.network.models.UserTokenRequest
import gustavo.projects.petlookup.network.models.UserTokenResponse
import retrofit2.Response
import javax.inject.Inject

class TokenServiceImpl @Inject constructor(
    private val apiService: ApiService
): TokenService {
    override suspend fun getToken(userTokenRequest: UserTokenRequest): Response<UserTokenResponse> {
        return apiService.getToken(userTokenRequest)
    }
}