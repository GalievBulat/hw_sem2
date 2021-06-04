package com.kakadurf.hw_sem2.presentation

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class ApplicationProxy : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    private val cicerone = Cicerone.create()
    val router = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    companion object {
        internal lateinit var INSTANCE: ApplicationProxy
            private set
    }
}
