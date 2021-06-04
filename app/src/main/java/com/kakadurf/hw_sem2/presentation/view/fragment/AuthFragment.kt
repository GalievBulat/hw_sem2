package com.kakadurf.hw_sem2.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.data.services.UserAuthorizationService
import com.kakadurf.hw_sem2.presentation.models.UserInfoDto
import kotlinx.android.synthetic.main.fragment_login.bt_auth_auth
import kotlinx.android.synthetic.main.fragment_login.bt_auth_reg
import kotlinx.android.synthetic.main.fragment_login.et_auth_email
import kotlinx.android.synthetic.main.fragment_login.et_auth_pssw

class AuthFragment : Fragment() {
    private val userAuthorizationService = UserAuthorizationService()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_auth_auth.setOnClickListener {
            val email = et_auth_email.text.toString()
            val password = et_auth_pssw.text.toString()
            if (!(email.isEmpty() || password.isEmpty())) {
                if (userAuthorizationService.authorize(email, password)) {
                    val action = AuthFragmentDirections.actionAuthFragmentToActivityMain(
                        UserInfoDto(
                            email,
                            password
                        )
                    )
                    findNavController().navigate(action)
                }
            }
        }
        bt_auth_reg.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_regFragment)
        }
    }
}
