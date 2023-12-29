package com.android.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weather.network.api.RetrofitClient
import com.android.weather.network.response.AirPollutionResponse
import com.android.weather.network.url.BasicApiUrls
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AirPollutionViewModel():ViewModel() {
    private val _airPollutionResponse  = MutableStateFlow<AirPollutionResponse?>(null)
    val airPollutionResponse: StateFlow<AirPollutionResponse?> get() = _airPollutionResponse

    private val _apiStatus  = MutableStateFlow("")
    val airPollutionApiStatus: StateFlow<String> get() = _apiStatus

    fun airPollutionApi(lat:Double,lon:Double){
        viewModelScope.launch {
            try{

                _airPollutionResponse.value = RetrofitClient.apiService.airPollution(
                    longitude =  lon,
                    latitude = lat,
                    apiKey = BasicApiUrls.API_KEY,
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