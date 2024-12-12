package com.example.wijiwaste.login

import androidx.lifecycle.ViewModel
import com.example.wijiwaste.data.UserRepository
import com.example.wijiwaste.userpref.UserModel

class LoginViewModel(private val repository: UserRepository): ViewModel() {

    fun login(email: String, password: String) = repository.login(email,password)

    suspend fun saveSession(userModel: UserModel){
        repository.saveSession(userModel)
    }
}