package com.kakadurf.hw_sem2.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.presentation.models.UserInfoDto
import kotlinx.android.synthetic.main.activity_main.navigationView

class ActivityMain : AppCompatActivity() {
    private var userInfo: UserInfoDto? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userInfo = savedInstanceState?.getParcelable<UserInfoDto>("usetInfo")
    }

    override fun onStart() {
        super.onStart()
        val navController = findNavController(R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(
            navigationView,
            navController
        )
    }
}
