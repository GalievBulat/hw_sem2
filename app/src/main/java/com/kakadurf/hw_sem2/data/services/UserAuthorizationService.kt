package com.kakadurf.hw_sem2.data.services

class UserAuthorizationService {
    fun authorize(login: String, password: String) = login == "test" && password == "test"
}
