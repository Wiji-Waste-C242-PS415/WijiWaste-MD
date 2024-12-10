package com.dicoding.capstone.mystoryapp.signup

import androidx.lifecycle.ViewModel
import com.dicoding.capstone.mystoryapp.data.UserRepository


class SignupViewModel(private val repository: UserRepository): ViewModel() {
    fun register(name: String, email: String, password: String) =
        repository.signup(name,email, password)
}