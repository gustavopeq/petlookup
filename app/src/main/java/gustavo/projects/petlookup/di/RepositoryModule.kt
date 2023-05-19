package gustavo.projects.petlookup.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gustavo.projects.petlookup.repositories.animals.AnimalsRepository
import gustavo.projects.petlookup.repositories.animals.AnimalsRepositoryImpl
import gustavo.projects.petlookup.repositories.token.TokenRepository
import gustavo.projects.petlookup.repositories.token.TokenRepositoryImpl
import gustavo.projects.petlookup.services.animals.AnimalsService
import gustavo.projects.petlookup.services.token.TokenService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTokenRepository(
        tokenService: TokenService
    ): TokenRepository {
        return TokenRepositoryImpl(tokenService)
    }

    @Singleton
    @Provides
    fun provideAnimalsRepository(
        animalsService: AnimalsService
    ): AnimalsRepository {
        return AnimalsRepositoryImpl(animalsService)
    }
}