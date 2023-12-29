package com.android.weather.ui.screen.location

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.widget.Toast
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.android.weather.ui.model.screens.WeatherScreens
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationScreen(navController: NavController) {

    val context = LocalContext.current
    val lat = remember {
        mutableStateOf(0.0)
    }
    val lon = remember {
        mutableStateOf(0.0)
    }

    RequestPermissionView(permission = Manifest.permission.ACCESS_FINE_LOCATION)

    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return
    }
    fusedLocationClient.getCurrentLocation(
        LocationRequest.PRIORITY_HIGH_ACCURACY, object : CancellationToken() {

            override fun onCanceledRequested(p0: OnTokenCanceledListener) = CancellationTokenSource().token

            override fun isCancellationRequested() = false
        })
        .addOnSuccessListener { location: Location? ->
            if (location == null)
                Toast.makeText(context, "no location!!!", Toast.LENGTH_SHORT).show()
            else {
                lat.value = location.latitude
                lon.value = location.longitude
                navController.navigate(WeatherScreens.WeatherScreen.passInfo( lat.value , lon.value ))
            }
        }

}

