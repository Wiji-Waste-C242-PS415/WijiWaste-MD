package com.dicoding.capstone.mystoryapp.login

import androidx.lifecycle.ViewModel
import com.dicoding.capstone.mystoryapp.data.UserRepository
import com.dicoding.capstone.mystoryapp.userpref.UserModel

class LoginViewModel(private val repository: UserRepository): ViewModel() {

    fun login(email: String, password: String) = repository.login(email,password)

    suspend fun saveSession(userModel: UserModel){
        repository.saveSession(userModel)
    }
}