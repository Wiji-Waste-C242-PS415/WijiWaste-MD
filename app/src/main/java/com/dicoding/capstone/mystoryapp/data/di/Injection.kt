package com.dicoding.capstone.mystoryapp.data.di

import android.content.Context
import com.dicoding.capstone.mystoryapp.data.UserRepository
import com.dicoding.capstone.mystoryapp.data.api.ApiConfig
import com.dicoding.capstone.mystoryapp.userpref.UserPreferences
import com.dicoding.capstone.mystoryapp.userpref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreferences.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return UserRepository.getInstance(apiService,pref)
    }
}