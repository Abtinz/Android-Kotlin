package com.android.weather.ui.model.screens

import com.android.weather.model.LandmarksDC
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.net.URLEncoder

sealed class WeatherScreens(val route:String) {

    object MainMenu : WeatherScreens(route = "home")

    object Location : WeatherScreens(route = "loation")
    object Map : WeatherScreens(route = "map")
    object CityList : WeatherScreens(route = "city_list")
    object Search : WeatherScreens(route = "search")

    object WeatherScreen: WeatherScreens(route = "weather/page/{location}"){
        fun passInfo(landmarks: LandmarksDC):String{
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val jsonAdapter = moshi.adapter(LandmarksDC::class.java).lenient()
            val landmarkJson = URLEncoder.encode(jsonAdapter.toJson(landmarks), "UTF-8")

            return "landmarks/page/${landmarkJson}"
        }
    }

    object AirPollutionScreen: WeatherScreens(route = "airpollution/page/{location}"){
        fun passInfo(landmarks: LandmarksDC):String{
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val jsonAdapter = moshi.adapter(LandmarksDC::class.java).lenient()
            val landmarkJson = URLEncoder.encode(jsonAdapter.toJson(landmarks), "UTF-8")

            return "landmarks/page/${landmarkJson}"
        }
    }

}