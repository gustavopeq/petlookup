package gustavo.projects.petlookup.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gustavo.projects.petlookup.models.Animals
import gustavo.projects.petlookup.ui.main.usecase.GetAnimalsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAnimalsUseCase: GetAnimalsUseCase
) : ViewModel() {

    private val _listOfAnimals = MutableLiveData<List<Animals>>()
    val listOfAnimals: LiveData<List<Animals>> = _listOfAnimals

    fun onGetAnimalsBtnClick() {
        viewModelScope.launch {
           val listOfAnimals = getAnimalsUseCase()

            _listOfAnimals.value = listOfAnimals
       }
    }
}