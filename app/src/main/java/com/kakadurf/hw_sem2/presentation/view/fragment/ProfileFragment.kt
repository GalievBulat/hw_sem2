package com.kakadurf.hw_sem2.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Navigator
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.presentation.ApplicationProxy
import com.kakadurf.hw_sem2.presentation.view.Screens
import kotlinx.android.synthetic.main.fragment_profile.bt_profile_info
import kotlinx.android.synthetic.main.fragment_profile.bt_profile_info2
import kotlinx.android.synthetic.main.fragment_profile.bt_profile_info3
import kotlinx.android.synthetic.main.fragment_profile.bt_profile_info4

class ProfileFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigator = object : Navigator {
            override fun applyCommands(commands: Array<out Command>) {
                commands.forEach {
                    when (it) {
                        is Forward -> {
                            when (val screen = it.screen) {
                                is Screens.InfoScreen -> {
                                    findNavController()
                                        .navigate(R.id.action_profileFragment_to_infoFragment)
                                }
                                is Screens.NewsScreen -> {
                                    findNavController()
                                        .navigate(R.id.action_profileFragment_to_newsFragment)
                                }
                                is Screens.SettingsScreen -> {
                                    findNavController()
                                        .navigate(R.id.action_profileFragment_to_settingsFragment)
                                }
                                is Screens.WeatherScreen -> {
                                    findNavController()
                                        .navigate(R.id.action_profileFragment_to_weatherFragment)
                                }
                            }
                        }
                        is BackTo -> {
                            findNavController().navigateUp()
                        }
                        else -> {
                        }
                    }
                }
            }
        }
        ApplicationProxy.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_profile_info.setOnClickListener {
            ApplicationProxy.INSTANCE.router.navigateTo(Screens.InfoScreen)
        }
        bt_profile_info2.setOnClickListener {
            ApplicationProxy.INSTANCE.router.navigateTo(Screens.NewsScreen)
        }
        bt_profile_info3.setOnClickListener {
            ApplicationProxy.INSTANCE.router.navigateTo(Screens.SettingsScreen)
        }
        bt_profile_info4.setOnClickListener {
            ApplicationProxy.INSTANCE.router.navigateTo(Screens.WeatherScreen)
        }
    }
}
