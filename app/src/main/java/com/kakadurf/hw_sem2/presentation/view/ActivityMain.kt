package com.kakadurf.hw_sem2.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kakadurf.hw_sem2.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class ActivityMain : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val fragmentManager : FragmentManager = supportFragmentManager

    private val onChoice: (String)->Unit = {
        Log.d("hi", "onChoose")
        swapFragment(
            ExtendedCharacterInfoFragment.createIndexed(
                it
            )
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_main)
            swapFragment(
                ListFragment()
            )
    }

    private fun swapFragment(fragment: Fragment){
        fragmentManager.beginTransaction().replace(R.id.fl_main,fragment)
            .addToBackStack("app_stack")
            .setReorderingAllowed(true)
            .commit()
    }

}