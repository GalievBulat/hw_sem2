package com.kakadurf.hw_sem2.presentation.view.interfaces

import com.kakadurf.hw_sem2.domain.Character
import com.kakadurf.hw_sem2.domain.Quote

interface ExtendedView {
    fun inflateCharacterData(character: Character)
    fun inflateQuotesData(quotes: List<Quote>)
}
