package gustavo.projects.petlookup.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gustavo.projects.petlookup.core.SessionPreferences
import gustavo.projects.petlookup.network.AuthInterceptor
import gustavo.projects.petlookup.network.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(sessionPreferences: SessionPreferences): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(sessionPreferences))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(sessionPreferences: SessionPreferences): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient(sessionPreferences))
            .build()
    }
}