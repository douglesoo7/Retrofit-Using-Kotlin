package com.example.kotlinretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("comments")
    fun getPosts(@Query("postId") postId:Int): Call<List<ResponseDTO>>

}