package com.dicoding.capstone.mystoryapp.userpref

data class UserModel (
    val token: String,
    val email: String,
    val password: String,
    val isLogin: Boolean = false
)
