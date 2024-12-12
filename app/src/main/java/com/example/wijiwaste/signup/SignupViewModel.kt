package com.example.wijiwaste.signup


import androidx.lifecycle.ViewModel

import com.example.wijiwaste.data.UserRepository


class SignupViewModel(private val repository: UserRepository): ViewModel() {
    fun register(name: String, email: String, password: String) =
        repository.signup(name,email, password)
}