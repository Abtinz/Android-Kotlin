package com.example.paging.network.api

import com.example.paging.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/users")
    suspend fun api(
        @Query("page") page: Int
    ):UserResponse
}