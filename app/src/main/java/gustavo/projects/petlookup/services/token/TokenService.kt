package gustavo.projects.petlookup.services.token

import gustavo.projects.petlookup.network.models.auth.UserTokenRequest
import gustavo.projects.petlookup.network.models.auth.UserTokenResponse
import retrofit2.Response

interface TokenService {
    suspend fun getToken(userTokenRequest: UserTokenRequest): Response<UserTokenResponse>
}