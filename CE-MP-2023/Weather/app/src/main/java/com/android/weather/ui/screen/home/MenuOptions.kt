package com.android.weather.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.android.weather.ui.theme.theme.secondary

@Composable
fun HomePageCategoriesCardView(title: String, image: String, modifier: Modifier,onClick:()->Unit) {
    val density = LocalDensity.current
    Column(
        modifier = modifier
    ){

        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,
            modifier = Modifier
                .size(200.dp)
                .padding(10.dp)
                .background()
                .clickable {
                    onClick()
                }
        ){
            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = "" ,
                modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.FillBounds,
            )
        }

        Text(
            text = title ,
            fontSize = with(density){18.dp.toSp()},
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Light,
            color = secondary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
