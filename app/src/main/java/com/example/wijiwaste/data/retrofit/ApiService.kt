package com.example.wijiwaste.data.retrofit

import com.example.wijiwaste.data.NewsItem
import com.example.wijiwaste.data.response.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("category/indonesia")
    fun getNews(): Call<ResponseNews>
}