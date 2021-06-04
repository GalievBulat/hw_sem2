package com.kakadurf.hw_sem2.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.presentation.models.UserInfoDto
import kotlinx.android.synthetic.main.fragment_reg.bt_reg
import kotlinx.android.synthetic.main.fragment_reg.et_reg_email
import kotlinx.android.synthetic.main.fragment_reg.et_reg_pssw

class RegFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_reg.setOnClickListener {
            if (!(et_reg_email.text.isEmpty() || et_reg_pssw.text.isEmpty())) {
                val action = RegFragmentDirections.actionRegFragmentToActivityMain(
                    UserInfoDto(
                        et_reg_email.text.toString(),
                        et_reg_email.text.toString()
                    )
                )
                findNavController().navigate(action)
            }
        }
    }
}
