package com.android.weather.network.api


import com.android.weather.network.response.AirPollutionResponse
import com.android.weather.network.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast")
    suspend fun weatherApi(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String
    ): WeatherResponse

    @GET("air_pollution")
    suspend fun pollutionInfo(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String
    ): AirPollutionResponse

}