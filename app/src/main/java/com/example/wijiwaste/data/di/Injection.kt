package com.example.wijiwaste.data.di

import android.content.Context
import com.example.wijiwaste.data.UserRepository
import com.example.wijiwaste.data.api.ApiConfig
import com.example.wijiwaste.userpref.UserPreferences
import com.example.wijiwaste.userpref.dataStore
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