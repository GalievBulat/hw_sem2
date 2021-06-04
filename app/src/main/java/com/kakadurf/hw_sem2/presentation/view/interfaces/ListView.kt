package com.kakadurf.hw_sem2.presentation.view.interfaces

import com.kakadurf.hw_sem2.presentation.models.CharacterDTO

interface ListView {
    fun onDataFetch(list: List<CharacterDTO>)
    fun onSearchDataFetch(id: String)
}
