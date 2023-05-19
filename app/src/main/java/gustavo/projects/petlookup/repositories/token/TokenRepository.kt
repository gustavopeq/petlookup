package gustavo.projects.petlookup.repositories.token

import gustavo.projects.petlookup.network.utils.SimpleResponse
import gustavo.projects.petlookup.network.models.UserTokenRequest
import gustavo.projects.petlookup.network.models.UserTokenResponse

interface TokenRepository {
    suspend fun getToken(userTokenRequest: UserTokenRequest): SimpleResponse<UserTokenResponse>
}