package com.android.weather.ui.screen.error.network

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SignalWifiStatusbarConnectedNoInternet4
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.weather.network.quality.UserNetworkChecker

class NetworkIsGone : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NetworkIsGoneScreen(tryAgainUnit :() -> Unit) {
    //UserNetworkChecker
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 32.dp)
        ) {
            Icon(
                imageVector = Icons.Default.SignalWifiStatusbarConnectedNoInternet4,
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier
                    .size(128.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Row{

                Text(
                    text = "No Internet Connection",
                    color = Color.Gray,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(end = 5.dp)
                )

                Text(
                    text = "Try Again",
                    color = Color.LightGray,
                    fontSize = 18.sp,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ){
                        if(UserNetworkChecker(context).checkNetwork){
                            tryAgainUnit()
                        }else{
                            Toast.makeText(context , "No Internet Connection!" , Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
        }
    }
}
