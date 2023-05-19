package gustavo.projects.petlookup.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gustavo.projects.petlookup.network.ApiService
import gustavo.projects.petlookup.services.animals.AnimalsService
import gustavo.projects.petlookup.services.animals.AnimalsServiceImpl
import gustavo.projects.petlookup.services.token.TokenService
import gustavo.projects.petlookup.services.token.TokenServiceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideTokenService(
        apiService: ApiService
    ): TokenService {
        return TokenServiceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideAnimalsService(
        apiService: ApiService
    ): AnimalsService {
        return AnimalsServiceImpl(apiService)
    }
}