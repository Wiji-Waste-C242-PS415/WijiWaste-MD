package com.example.wijiwaste


import androidx.lifecycle.ViewModel
import com.example.wijiwaste.data.UserRepository

class MainViewModel(private val repository: UserRepository): ViewModel() {
    fun getStories() = repository.getStory()

    suspend fun logout(){
        repository.logout()
    }

}
