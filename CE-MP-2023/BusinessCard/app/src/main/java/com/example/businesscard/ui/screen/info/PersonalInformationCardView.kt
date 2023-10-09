package com.example.businesscard.ui.screen.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.School
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.businesscard.ui.theme.CardBordersColor
import com.example.businesscard.ui.theme.CardsBackGround
import com.example.businesscard.ui.theme.titlesColor

@Composable
fun PersonalInformationCardView(rotationClick : () -> Unit) {

    val density = LocalDensity.current //will be used for dynamic text sizes

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "abtin zandi image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Abtin Zandi",
            color = ValueColor,
            fontSize = with(density){24.dp.toSp()},
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        InformationRowView(
            value =  "Iran/Tehran",
            icon = Icons.Default.LocationOn
        )

        InformationRowView(
            value =  "Android Developer",
            icon = Icons.Default.Work
        )

        InformationRowView(
            value = "Uritect",
            icon = Icons.Default.Apartment
        )

        InformationRowView(
            value = "Amirkabir University of Technology",
            icon = Icons.Default.School
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onClick = {
                rotationClick()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = CardBordersColor, contentColor = CardsBackGround)
        ) {
            Text(
                text = "Skills and Contact",
                fontSize = with(density){18.dp.toSp()},
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
            )
        }
    }
}

@Composable
fun InformationRowView(value:String , icon:ImageVector) {

    val density = LocalDensity.current //will be used for dynamic text sizes

    Row(
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp),
            tint = titlesColor
        )

        Text(
            text = value,
            color = ValueColor,
            fontSize = with(density){16.dp.toSp()},
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
        )
    }
}