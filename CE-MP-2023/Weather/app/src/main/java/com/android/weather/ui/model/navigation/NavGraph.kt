package com.android.weather.ui.model.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.weather.ui.model.screens.WeatherScreens
import com.android.weather.ui.screen.home.MainMenuScreen

@ExperimentalMaterialApi
@Composable
fun NavigationGraph (navHostController: NavHostController){

    NavHost(
        navController = navHostController,
        startDestination = WeatherScreens.MainMenu.route
    ) {
        composable(route = WeatherScreens.MainMenu.route) {
            MainMenuScreen(navController = navHostController)
        }

        composable(route = WeatherScreens.Map.route) {
            MainMenuScreen(navController = navHostController)
        }

        composable(route = WeatherScreens.Location.route) {
            MainMenuScreen(navController = navHostController)
        }

        composable(route = WeatherScreens.Search.route) {
            MainMenuScreen(navController = navHostController)
        }

        composable(route = WeatherScreens.CityList.route) {
            MainMenuScreen(navController = navHostController)
        }

    }
}