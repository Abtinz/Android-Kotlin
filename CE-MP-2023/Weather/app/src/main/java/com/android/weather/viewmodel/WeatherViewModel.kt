package com.android.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weather.network.api.RetrofitClient
import com.android.weather.network.response.WeatherResponse
import com.android.weather.network.url.BasicApiUrls.API_KEY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel():ViewModel() {

    private val _weatherResponse  = MutableStateFlow<WeatherResponse?>(null)
    val weatherResponse: StateFlow<WeatherResponse?> get() = _weatherResponse

    private val _apiStatus  = MutableStateFlow("")
    val apiStatus:StateFlow<String>  get() = _apiStatus

    fun weatherApi(lat:Double,lon:Double){
        viewModelScope.launch {
            try{

                _weatherResponse.value = RetrofitClient.apiService.weatherApi(
                    longitude =  lon,
                    latitude = lat,
                    apiKey = API_KEY
                )

                _apiStatus.value = "200"
            }catch (exception:Exception){
                exception.printStackTrace()
                if (exception.message.toString().contains("50")) {
                    _apiStatus.value = "server time out"
                }else{
                    _apiStatus.value = "some things went wrong"
                }
            }
        }
    }
}