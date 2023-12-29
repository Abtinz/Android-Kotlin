package com.android.weather.ui.screen.cityList

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.weather.model.ProvincesDC
import com.android.weather.ui.model.screens.WeatherScreens
import com.android.weather.ui.screen.weather.WeatherScreen
import com.android.weather.ui.theme.theme.secondary

@Composable
fun ProvinceCardView(provinces: ProvincesDC,navController: NavController) {

    
        var expandedState by remember { mutableStateOf(false) }
        val rotationState by animateFloatAsState(
            targetValue = if (expandedState) 180f else 0f,
            label = ""
        )

        Column {
            Spacer(modifier = Modifier.size(18.dp))
            Card(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            easing = LinearOutSlowInEasing,
                            durationMillis = 200
                        )
                    )
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        expandedState = !expandedState
                    }
                    .padding(start = 10.dp, top = 10.dp, bottom = 20.dp, end = 10.dp),
                shape = RoundedCornerShape(5.dp),
                elevation = 2.dp
            ) {

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                ) {

                    Row {

                        Text(
                            text = provinces.name,
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1f),
                            color = Color.DarkGray,
                            fontSize = 18.sp
                        )

                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "ArrowDropDown",
                            tint = Color.DarkGray,
                            modifier = Modifier
                                .rotate(rotationState)
                                .padding(5.dp)
                                .size(25.dp)
                        )

                    }

                    if (expandedState) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            provinces.cities.forEach {
                                Text(
                                    text = it.name,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .clickable {
                                            navController.navigate(
                                                WeatherScreens.WeatherScreen.passInfo(
                                                    lat = it.lat,
                                                    lan = it.lon
                                                )
                                            )
                                        }
                                        .weight(1f),
                                    color = secondary,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }

                }
            }
        }
}