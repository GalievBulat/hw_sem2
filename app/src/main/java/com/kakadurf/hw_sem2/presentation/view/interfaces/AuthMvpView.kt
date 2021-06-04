package com.kakadurf.hw_sem2.presentation.view.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AuthMvpView : MvpView {
    fun onSearchDataFetch(id: Int)
    fun checkPerms()
}
