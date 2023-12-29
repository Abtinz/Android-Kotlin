package com.android.weather.network.api


import com.android.weather.network.response.PollutionResponse
import com.android.weather.network.response.WeatherResponse
import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun weatherPage(): WeatherResponse

    @GET("")
    suspend fun pollutionInfo(): List<PollutionResponse>

}