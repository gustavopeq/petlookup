package gustavo.projects.petlookup.ui.main.usecase

import gustavo.projects.petlookup.models.Animals
import gustavo.projects.petlookup.repositories.animals.AnimalsRepository
import javax.inject.Inject

class GetAnimalsUseCase @Inject constructor(
    private val animalsRepository: AnimalsRepository
) {
    suspend operator fun invoke(): List<Animals> {
        val response = animalsRepository.fetchAnimals()

        return if (response.isSuccessful) {
            response.body.animals
        } else {
            emptyList()
        }
    }
}