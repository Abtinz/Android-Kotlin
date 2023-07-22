package com.example.hiltdagger.network.api

import retrofit2.http.GET

interface ApiService {
    @GET("no-where/")
    suspend fun api()
}