package com.kakadurf.hw_sem2.presentation.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakadurf.hw_sem2.data.services.InformationProviderFacade
import com.kakadurf.hw_sem2.presentation.models.CharacterDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    val list: MutableLiveData<List<CharacterDTO>> = MutableLiveData()
    fun findCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val str =
                InformationProviderFacade.getCharacters()
            Log.d("hi", "got it")
            val dtoSet: ArrayList<CharacterDTO> = ArrayList()
            str.forEach { character ->
                dtoSet.add(
                    CharacterDTO(
                        character.id,
                        character.name,
                        character.race,
                        character.gender,
                        character.realm,
                        character.wikiUrl
                    )
                )
            }
            launch(Dispatchers.Main) {
                list.value = dtoSet
            }
            // viewState.onDataFetch(dtoSet)
        }
    }
}
