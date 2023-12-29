package com.android.weather.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.android.weather.R
import com.android.weather.ui.model.screens.WeatherScreens
import com.android.weather.ui.theme.theme.mainBackGround
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainMenuScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(mainBackGround)
    ) {
        HomePageCategoriesCardView(
            title = stringResource(id =  R.string.location),
            icon = Icons.Default.LocationOn,
            onClick = {

                navController.navigate(WeatherScreens.Location.route)
            }
        )

        HomePageCategoriesCardView(
            title = stringResource(id =  R.string.choose_your_location),
            icon = Icons.AutoMirrored.Filled.List,
            onClick = {
                navController.navigate(WeatherScreens.CityList.route)
            }
        )

        HomePageCategoriesCardView(
            title = stringResource(id =  R.string.search),
            icon = Icons.Default.Search,
            onClick = {
                navController.navigate(WeatherScreens.Search.route)
            }
        )

        HomePageCategoriesCardView(
            title = stringResource(id =  R.string.map),
            icon = Icons.Default.Map,
            onClick = {
                navController.navigate(WeatherScreens.Map.route)
            }
        )
    }

}