package com.android.weather.ui.model.screens

import com.android.weather.model.LandmarksDC
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.net.URLEncoder

sealed class WeatherScreens(val route:String) {

    object MainMenu : WeatherScreens(route = "home")

    object Location : WeatherScreens(route = "location")
    object Map : WeatherScreens(route = "map")
    object CityList : WeatherScreens(route = "city_list")
    object Search : WeatherScreens(route = "search")

    object WeatherScreen: WeatherScreens(route = "weather/page/{lat}/{lon}"){
        fun passInfo(lat:Double, lan:Double):String{
            return "weather/page/${lat.toString()}/${lan.toString()}"
        }
    }

}