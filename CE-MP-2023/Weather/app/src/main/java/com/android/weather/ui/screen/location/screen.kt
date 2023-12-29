package com.android.weather.ui.screen.location

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationScreen(navController: NavController) {
    RequestPermissionView(permission = Manifest.permission.ACCESS_FINE_LOCATION)
}

