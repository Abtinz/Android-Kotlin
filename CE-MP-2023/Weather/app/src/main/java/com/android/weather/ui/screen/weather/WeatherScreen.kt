package com.android.weather.ui.screen.weather

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.android.weather.network.quality.UserNetworkChecker
import com.android.weather.ui.model.reload.Reload
import com.android.weather.ui.screen.error.network.NetworkIsGoneScreen
import com.android.weather.ui.screen.error.server.ServerErrorScreen
import com.android.weather.ui.screen.error.server.SomethingWentWrongScreen
import com.android.weather.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(navController: NavController , lat :Double , lon:Double) {
    val context = LocalContext.current

    val isInternetAvailable = remember{
        mutableStateOf(UserNetworkChecker(context).checkNetwork)
    }

    if(isInternetAvailable.value) {
        val viewModel = viewModel(modelClass = WeatherViewModel::class.java)
        LaunchedEffect(key1 = context) {
            viewModel.weatherApi(lat = lat , lon = lon)
        }
        val weatherResponse by viewModel.weatherResponse.collectAsState()
        val apiStatus by viewModel.apiStatus.collectAsState()

        if (weatherResponse == null) {
            //the api is under processing so we have to show reloading
            if (apiStatus.isBlank()) {
                Reload()
            } else {
                //server or intent or unknown errors are occurred
                if (apiStatus == "server time out") {
                    ServerErrorScreen()
                } else if (apiStatus == "some things went wrong") {
                    SomethingWentWrongScreen()
                }
            }
        } else {
            LazyColumn{
                items(weatherResponse!!.list){
                    WeatherCardView(weather = it)
                }
            }
        }
    }else{
        NetworkIsGoneScreen{
            isInternetAvailable.value = true
        }
    }
}