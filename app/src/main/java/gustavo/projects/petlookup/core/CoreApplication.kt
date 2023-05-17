package gustavo.projects.petlookup.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import gustavo.projects.petlookup.network.ApiClient
import gustavo.projects.petlookup.network.models.UserTokenRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CoreApplication: Application() {

    @Inject
    lateinit var apiClient: ApiClient

    @Inject
    lateinit var sessionPreferences: SessionPreferences


    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.Main).launch {
            val tokenRequest = apiClient.getToken(UserTokenRequest())

            if (tokenRequest.failed || !tokenRequest.isSuccessful) {
                println("PRINT - Token request failed!")
                return@launch
            }

            tokenRequest.body.accessToken.let { token ->
                println("PRINT - Access Token: $token")
                sessionPreferences.saveAuthToken(token)
            }
        }
    }
}