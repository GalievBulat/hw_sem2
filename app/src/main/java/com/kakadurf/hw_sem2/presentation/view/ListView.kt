package com.kakadurf.hw_sem2.presentation.view

import com.kakadurf.hw_sem2.presentation.models.CharacterDTO

interface ListView{
    fun onDataFetch (list: List<CharacterDTO>)
    fun onSearchDataFetch (id: String)
}