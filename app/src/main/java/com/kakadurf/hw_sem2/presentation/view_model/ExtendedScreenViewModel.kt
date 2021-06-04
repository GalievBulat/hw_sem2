package com.kakadurf.hw_sem2.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakadurf.hw_sem2.data.services.InformationProviderFacade
import com.kakadurf.hw_sem2.domain.Character
import com.kakadurf.hw_sem2.domain.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExtendedScreenViewModel : ViewModel() {
    val characterInfo: MutableLiveData<Character> = MutableLiveData()
    val characterQuotes: MutableLiveData<List<Quote>> = MutableLiveData()
    fun getCharacter(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val character = InformationProviderFacade.getSpecificCharacter(
                id
            )
            launch(Dispatchers.Main) {
                characterInfo.value = character
            }
            // viewState.inflateCharacterData(it)
        }
    }

    fun getQuotes(characterId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val quotes = InformationProviderFacade.getSpecificQuotes(
                characterId
            )
            launch(Dispatchers.Main) {
                characterQuotes.value = quotes
                // viewState.inflateQuotesData(it)
            }
        }
    }
}
