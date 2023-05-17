package gustavo.projects.petlookup.network.models

import com.google.gson.annotations.SerializedName

data class UserTokenRequest(
    @SerializedName("grant_type")
    val grantType: String = "client_credentials",
    @SerializedName("client_id")
    var clientId: String = "KqHKanmRoCrl416ZKhS2S9Wf2ce1aD2XuMHJWouMcHfeTgcGDl",
    @SerializedName("client_secret")
    var clientSecret: String = "7ZJmHU94TfAxiEMa4Y7ldDtRTeAPAF61JvkG8ATr"
)