package gustavo.projects.petlookup.network

import android.content.Context
import gustavo.projects.petlookup.network.Constants.AUTH_BEARER_PREFIX
import gustavo.projects.petlookup.network.Constants.AUTH_HEADER_NAME
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context): Interceptor {

    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader(AUTH_HEADER_NAME, "$AUTH_BEARER_PREFIX $it")
        }

        return chain.proceed(requestBuilder.build())
    }

}