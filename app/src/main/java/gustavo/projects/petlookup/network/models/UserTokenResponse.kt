package gustavo.projects.petlookup.network.models

import com.google.gson.annotations.SerializedName

data class UserTokenResponse(
    @SerializedName("token_type")
    var tokenType: String,
    @SerializedName("expires_in")
    var expiresInSec: Long,
    @SerializedName("access_token")
    var accessToken: String
)
