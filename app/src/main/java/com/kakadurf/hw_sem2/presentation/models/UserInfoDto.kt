package com.kakadurf.hw_sem2.presentation.models

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfoDto(
    val email: String,
    val password: String
) : NavArgs, Parcelable {
    fun fromBundle(bundle: Bundle): UserInfoDto =
        UserInfoDto(
            bundle.getString("email") ?: "",
            bundle.getString("password") ?: ""
        )
}
