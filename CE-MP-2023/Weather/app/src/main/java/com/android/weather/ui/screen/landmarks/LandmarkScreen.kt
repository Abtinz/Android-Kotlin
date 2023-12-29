package com.android.iranname.landmarks.ui.screen.landmarks

import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.iranname.commonServices.ui.compose.ImageSlider
import com.android.iranname.landmarks.model.LandmarksDC
import com.android.weather.ui.theme.theme.informationText
import com.android.weather.ui.theme.theme.primary
import io.github.giangpham96.expandable_text_compose.ExpandableText

@Composable
fun LandmarkScreens(landmarksDC: LandmarksDC) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
            Spacer(modifier = Modifier.padding(10.dp))
            ImageSlider(images = landmarksDC.images)


        val density = LocalDensity.current
        Text(
            text = landmarksDC.name,
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            fontSize = with(density){24.dp.toSp()},
            color = primary,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){


            Text(
                text = landmarksDC.location,
                textAlign = TextAlign.Right,
                style = MaterialTheme.typography.displaySmall,
                fontSize = with(density){16.dp.toSp()},
                color = primary,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp),
                tint = primary
            )
        }

        var expand by remember {
            mutableStateOf(false)
        }

        ExpandableText(
            originalText = landmarksDC.description,
            style = TextStyle(
                textAlign = TextAlign.Right
            ),
            expandAction = "See More",
            expandActionColor = primary,
            expand = expand,
            fontSize = with(density){16.dp.toSp()},
            color = informationText,
            fontFamily = FontFamily.SansSerif,
            limitedMaxLines = 2,
            animationSpec = spring(),
            modifier = Modifier
                .clickable { expand = !expand }
                .padding(10.dp)
        )


    }
}