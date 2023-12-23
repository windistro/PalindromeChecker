package com.example.palindromechecker.data.remote

import com.example.palindromechecker.data.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUser(
        @Query("page") page: Int = 1,
        @Query("per_page") size: Int = 4
    ): UserResponse
}