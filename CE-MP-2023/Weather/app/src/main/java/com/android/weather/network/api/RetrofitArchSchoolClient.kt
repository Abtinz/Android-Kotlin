package com.android.weather.network.api

import com.android.weather.network.url.BasicApiUrls.BASIC_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitArchSchoolClient {

    //moshi converter
    private val moshi =  Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    //retrofit service
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASIC_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    //instances will implement here :
    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}