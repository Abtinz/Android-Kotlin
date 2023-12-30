package com.android.weather.ui.screen.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.weather.network.quality.UserNetworkChecker
import com.android.weather.ui.model.reload.Reload
import com.android.weather.ui.screen.error.network.NetworkIsGoneScreen
import com.android.weather.ui.screen.error.server.ServerErrorScreen
import com.android.weather.ui.screen.error.server.SomethingWentWrongScreen
import com.android.weather.ui.theme.theme.mainBackGround
import com.android.weather.ui.theme.theme.primary
import com.android.weather.viewmodel.AirPollutionViewModel
import com.android.weather.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(lat: Double, lon: Double) {
    val context = LocalContext.current

    val isInternetAvailable = remember{
        mutableStateOf(UserNetworkChecker(context).checkNetwork)
    }

    if(isInternetAvailable.value) {
        val viewModel = viewModel(modelClass = WeatherViewModel::class.java)
        val secondViewModel = viewModel(modelClass = AirPollutionViewModel::class.java)
        LaunchedEffect(key1 = context) {
            secondViewModel.airPollutionApi(lat = lat , lon = lon)
            viewModel.weatherApi(lat = lat , lon = lon)

        }
        val airPollutionResponse by secondViewModel.airPollutionResponse.collectAsState()
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

                item{
                    if(airPollutionResponse != null){
                        Card(
                            modifier = Modifier
                                .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp)
                                .fillMaxWidth(),
                            shape  = RoundedCornerShape(10.dp) ,
                            elevation = 3.dp
                        ){
                                Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(mainBackGround),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                              val aqi = airPollutionResponse!!.list[0].components.pm10.toInt()
                              val color = if(aqi < 50){
                                   Color.Green
                               }else if (aqi in 51..99){
                                   Color.Yellow
                               }else if (aqi in 100..150){
                                   Color(0xFFFF531C)
                               }else if (aqi in 150..200){
                                    Color.Red
                               }else if (aqi in 200..300){
                                   Color(0xFF9C27B0)
                               }else{
                                   Color(0xFF522C20)
                               }

                                Box(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .background(color),
                                )
                                Text(
                                    "$aqi  AQI...        وضعیت آلودگی هوا",
                                    color = primary ,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp ,
                                    modifier = Modifier
                                        .padding(start = 10.dp , end = 10.dp , top = 5.dp , bottom = 5.dp)
                                )
                            }
                        }
                    }
                }
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