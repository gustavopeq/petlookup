package gustavo.projects.petlookup.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gustavo.projects.petlookup.ui.main.usecase.GetAnimalsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAnimalsUseCase: GetAnimalsUseCase
) : ViewModel() {

    fun onGetAnimalsBtnClick() {
        viewModelScope.launch {
           val listOfAnimals = getAnimalsUseCase()

           println("PRINT - $listOfAnimals")
       }
    }
}