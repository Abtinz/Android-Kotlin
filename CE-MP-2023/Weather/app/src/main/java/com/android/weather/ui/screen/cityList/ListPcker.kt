package com.android.weather.ui.screen.cityList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.android.weather.viewmodel.ProvinceListViewModel

@Composable
fun CityPicker(navController: NavController) {
    val viewModel = viewModel(ProvinceListViewModel::class.java)
    val provinces = viewModel.provinceResources()
    LazyColumn{
        items(provinces) {
            ProvinceCardView(provinces = it, navController = navController)
        }
    }
}

