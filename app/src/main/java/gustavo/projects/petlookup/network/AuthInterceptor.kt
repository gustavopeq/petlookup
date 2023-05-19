package gustavo.projects.petlookup.network

import gustavo.projects.petlookup.core.SessionPreferences
import gustavo.projects.petlookup.network.utils.Constants.AUTH_BEARER_PREFIX
import gustavo.projects.petlookup.network.utils.Constants.AUTH_HEADER_NAME
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sessionPreferences: SessionPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionPreferences.fetchAuthToken()?.let {
            requestBuilder.addHeader(AUTH_HEADER_NAME, "$AUTH_BEARER_PREFIX $it")
        }

        return chain.proceed(requestBuilder.build())
    }

}