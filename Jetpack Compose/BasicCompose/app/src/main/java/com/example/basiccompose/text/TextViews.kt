package com.example.basiccompose.text

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFunction() {
    LazyColumn{
        item {
            Text(
                "Hi Android"
            )

            //static font size
            Text(
                "Hi Android",
                fontSize = 10.sp
            )

            //dynamic size
            val density = LocalDensity.current
            Text(
                "Hi Android",
                fontSize = with(density){15.dp.toSp()}
            )

            //line height size
            Text(
                "Hi Android",
                fontSize = with(density){15.dp.toSp()},
                lineHeight = 100.sp
            )

            Text(
                "Hi Android",
                fontSize = with(density){15.dp.toSp()},
                color = Color.Red
            )

            Text(
                "Hi Android",
                fontSize = with(density){15.dp.toSp()},
                color = Color.Red,
                fontStyle = FontStyle.Italic
            )

            Text(
                "Hi Android",
                fontSize = with(density){15.dp.toSp()},
                color = Color.Red,
                fontFamily = FontFamily.Cursive
            )
        }
    }
}