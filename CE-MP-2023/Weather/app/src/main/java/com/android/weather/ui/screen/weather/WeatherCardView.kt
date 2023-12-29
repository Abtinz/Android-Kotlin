package com.android.weather.ui.screen.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.weather.network.response.WeatherItem
import com.android.weather.ui.theme.theme.secondary
import com.android.weather.ui.theme.theme.tertiary

@Composable
fun WeatherCardView(weather : WeatherItem) {

    Card(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp)
            .fillMaxWidth(),
        shape  = RoundedCornerShape(10.dp) ,
        elevation = 3.dp
    ){
        val density = LocalDensity.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(tertiary),
            horizontalAlignment = Alignment.End
        ){

            Text(
                weather.dt_txt,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = secondary ,
                fontWeight = FontWeight.Bold,
                fontSize = with(density){ 18.dp.toSp()} ,
                modifier = Modifier
                    .padding(start = 10.dp , end = 10.dp , top = 5.dp , bottom = 5.dp)
            )

            Text(
                weather.weather[0].description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = secondary ,
                fontWeight = FontWeight.Bold,
                fontSize = with(density){ 18.dp.toSp()} ,
                modifier = Modifier
                    .padding(start = 10.dp , end = 10.dp , top = 5.dp , bottom = 5.dp)
            )

            Text(
                weather.weather[0].main,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = secondary ,
                fontWeight = FontWeight.Bold,
                fontSize = with(density){ 18.dp.toSp()} ,
                modifier = Modifier
                    .padding(start = 10.dp , end = 10.dp , top = 5.dp , bottom = 5.dp)
            )

            Text(
                "دمای هوا${weather.main.temp}",
                color = secondary ,
                fontWeight = FontWeight.Bold,
                fontSize = with(density){ 18.dp.toSp()} ,
                modifier = Modifier
                    .padding(start = 10.dp , end = 10.dp , top = 5.dp , bottom = 5.dp)
            )

            Text(
                "رطوبت${weather.main.humidity}",
                color = secondary ,
                fontWeight = FontWeight.Bold,
                fontSize = with(density){ 18.dp.toSp()} ,
                modifier = Modifier
                    .padding(start = 10.dp , end = 10.dp , top = 5.dp , bottom = 5.dp)
            )

        }
    }
}