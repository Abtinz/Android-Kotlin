package com.android.weather.ui.screen.error.server

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SomethingWentWrongScreen() {

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
                imageVector = Icons.Default.ErrorOutline,
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier
                    .size(128.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )

            Text(
                text = "Something Went Wrong! Please try again in a few minutes. ",
                color = Color.Gray,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

        }
    }
}