package com.example.businesscard.ui.screen.skills

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Recommend
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.businesscard.R
import com.example.businesscard.ui.screen.info.InformationRowView
import com.example.businesscard.ui.theme.BackgroundColor
import com.example.businesscard.ui.theme.CardBordersColor
import com.example.businesscard.ui.theme.CardsBackGround
import com.example.businesscard.ui.theme.ValueColor

@Composable
fun PersonalSkills(rotationClick: () -> Unit) {

    val density = LocalDensity.current //will be used for dynamic text sizes

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Text(
            text = "Skills",
            color = BackgroundColor,
            fontSize = with(density){24.dp.toSp()},
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        InformationRowView(
            value =  "Android Development(Kotlin)",
            icon = Icons.Default.Android
        )

        InformationRowView(
            value = "Recommender Systems",
            icon = Icons.Default.Recommend
        )

        InformationRowView(
            value =  "Natural Language Processing",
            icon = Icons.Default.Language
        )

        InformationRowView(
            value =  "Computer Vision",
            icon = Icons.Default.RemoveRedEye
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
                text = "Personal Info.",
                fontSize = with(density){18.dp.toSp()},
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
            )
        }
    }
}