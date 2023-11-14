package abtin.android.zabol.ui.screen

import abtin.android.zabol.model.Landmarks
import abtin.android.zabol.ui.theme.informationText
import abtin.android.zabol.ui.theme.primary
import abtin.android.zabol.ui.theme.tertiary
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.businesscard.R
import io.github.giangpham96.expandable_text_compose.ExpandableText

@Composable
fun LandmarksCardView(landmarkInfo:Landmarks) {
    Card(
        modifier = Modifier
            .padding(top = 10.dp, end = 10.dp, start = 10.dp)
            .background(color = tertiary, shape = RoundedCornerShape(8.dp))
            .animateContentSize(
                animationSpec = tween(
                    easing = LinearOutSlowInEasing,
                    durationMillis = 200
                )
            ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            Modifier.background(color = tertiary)
        ){
            Image(
                painter =rememberAsyncImagePainter(landmarkInfo.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.image_paddings))
                    .height(dimensionResource(id = R.dimen.image_height))
                    .fillMaxWidth()
            )

            val density = LocalDensity.current
            Text(
                text = landmarkInfo.name,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                fontSize = with(density){24.dp.toSp()},
                color = primary,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.text_padding))
            )

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp),
                    tint = primary
                )

                Text(
                    text = landmarkInfo.location,
                    style = MaterialTheme.typography.displaySmall,
                    fontSize = with(density){16.dp.toSp()},
                    color = primary,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.text_padding))
                        .weight(1f)
                )
            }

            var expand by remember {
                mutableStateOf(false)
            }

            ExpandableText(
                originalText = landmarkInfo.description,
                style = TextStyle(
                    textAlign = TextAlign.Justify
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
}