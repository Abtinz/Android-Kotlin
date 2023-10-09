package com.example.businesscard.ui.screen.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.businesscard.R
import com.example.businesscard.ui.theme.ValueColor
import androidx.compose.ui.Alignment
import com.example.businesscard.ui.theme.CardsBackGround
import com.example.businesscard.ui.theme.titlesColor

@Composable
fun PersonalInformationCardView() {

    val density = LocalDensity.current //will be used for dynamic text sizes

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(start = 40.dp, end = 40.dp),
        backgroundColor = CardsBackGround,
        shape = RoundedCornerShape(0.dp),
        elevation  = 10.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "abtin zandi image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(100.dp)
                    .border(width = 4.dp, color = ValueColor)
                    .padding(top = 10.dp)
            )

            Text(
                text = "Abtin Zandi",
                color = ValueColor,
                fontSize = with(density){24.dp.toSp()},
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
            )

            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp),
                        tint = titlesColor
                )

                Text(
                    text = "Iran/Tehran",
                    color = ValueColor,
                    fontSize = with(density){16.dp.toSp()},
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.Work,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp),
                    tint = titlesColor
                )

                Text(
                    text = "Android Developer",
                    color = ValueColor,
                    fontSize = with(density){16.dp.toSp()},
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                )
            }

        }

    }
}