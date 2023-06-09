package gustavo.projects.petlookup.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import gustavo.projects.petlookup.network.models.auth.UserTokenRequest
import gustavo.projects.petlookup.repositories.token.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CoreApplication: Application() {

    @Inject
    lateinit var tokenRepository: TokenRepository

    @Inject
    lateinit var sessionPreferences: SessionPreferences


    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.Main).launch {
            val tokenRequest = tokenRepository.getToken(UserTokenRequest())

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