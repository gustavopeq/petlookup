package gustavo.projects.petlookup.repositories.token

import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.auth.UserTokenRequest
import gustavo.projects.petlookup.network.models.auth.UserTokenResponse

interface TokenRepository {
    suspend fun getToken(userTokenRequest: UserTokenRequest): SimpleResponse<UserTokenResponse>
}