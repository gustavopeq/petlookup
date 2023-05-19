package gustavo.projects.petlookup.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gustavo.projects.petlookup.repositories.animals.AnimalsRepository
import gustavo.projects.petlookup.ui.main.usecase.GetAnimalsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetAnimalsUseCase(animalsRepository: AnimalsRepository): GetAnimalsUseCase =
        GetAnimalsUseCase(animalsRepository)
}