package com.android.weather.model

data class Location(
    val province:String,
    val city:String
)

data class ProvincesDC(
    val name:String,
    val cities:List<City>
)

data class City(
    val name :String,
    val lat :Double,
    val lon : Double
)

