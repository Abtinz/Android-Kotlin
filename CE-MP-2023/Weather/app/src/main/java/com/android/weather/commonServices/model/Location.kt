package com.android.weather.commonServices.model

data class Location(
    val province:String,
    val city:String
)

data class ProvincesDC(
    val name:String,
    val cities:List<String>
)

