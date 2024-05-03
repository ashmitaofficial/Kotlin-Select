package com.example.kotlinsecond.network

import com.example.kotlinsecond.model.Todo
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    fun getTodos():Call<ArrayList<Todo>>
}