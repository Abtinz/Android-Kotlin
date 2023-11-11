package com.example.basiccompose.preview

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "simple preview")
@Composable
fun SimplePreview(){
    Text(
        "Hi Android"
    )
}

@Preview(
    name = "BackGround preview",
    showBackground = true,
    backgroundColor = 0xFFFFFF
)
@Composable
fun BackGroundPreview(){
    Text(
        "Hi Android"
    )
}

@Preview(
    name = "BackGround preview",
    showSystemUi = true,
)
@Composable
fun SystemUiPreview(){
    Text(
        "Hi Android"
    )
}
