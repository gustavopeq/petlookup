package gustavo.projects.petlookup.repositories.token

import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.auth.UserTokenRequest
import gustavo.projects.petlookup.network.models.auth.UserTokenResponse
import gustavo.projects.petlookup.network.utils.safeApiCall
import gustavo.projects.petlookup.services.token.TokenService
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenService: TokenService
): TokenRepository {
    override suspend fun getToken(
        userTokenRequest: UserTokenRequest
    ): SimpleResponse<UserTokenResponse> {
        return safeApiCall { tokenService.getToken(userTokenRequest) }
    }
}