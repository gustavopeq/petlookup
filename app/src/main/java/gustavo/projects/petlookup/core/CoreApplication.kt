package gustavo.projects.petlookup.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import gustavo.projects.petlookup.network.ApiService
import gustavo.projects.petlookup.network.models.UserTokenRequest
import gustavo.projects.petlookup.network.models.UserTokenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltAndroidApp
class CoreApplication: Application() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var sessionPreferences: SessionPreferences


    override fun onCreate() {
        super.onCreate()
        apiService.getToken(UserTokenRequest()).enqueue(
            object : Callback<UserTokenResponse> {
                override fun onFailure(call: Call<UserTokenResponse>, t: Throwable) {
                    println("PRINT - on Failure")
                }

                override fun onResponse(
                    call: Call<UserTokenResponse>,
                    response: Response<UserTokenResponse>
                ) {
                    val userTokenResponse = response.body()

                    userTokenResponse?.accessToken?.let { token ->
                        println("PRINT - Access Token: $token")
                        sessionPreferences.saveAuthToken(token)
                    }
                }
            }
        )
    }
}