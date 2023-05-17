package gustavo.projects.petlookup.network.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gustavo.projects.petlookup.network.ApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providePetfinderApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}