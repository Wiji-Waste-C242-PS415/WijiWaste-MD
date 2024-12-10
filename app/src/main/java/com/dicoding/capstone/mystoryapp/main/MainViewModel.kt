package com.dicoding.capstone.mystoryapp.main

import androidx.lifecycle.ViewModel
import com.dicoding.capstone.mystoryapp.data.UserRepository

class MainViewModel(private val repository: UserRepository): ViewModel() {
    fun getStories() = repository.getStory()

    suspend fun logout(){
        repository.logout()
    }

    }
