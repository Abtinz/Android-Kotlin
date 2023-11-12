package abtin.android.zabol.ui.screen

import abtin.android.zabol.model.Landmarks
import abtin.android.zabol.ui.theme.informationText
import abtin.android.zabol.ui.theme.primary
import abtin.android.zabol.ui.theme.secondary
import abtin.android.zabol.ui.theme.tertiary
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.businesscard.R

@Composable
fun LandmarksCardView(landmarkInfo:Landmarks) {
    Card(

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
                style = MaterialTheme.typography.titleMedium,
                fontSize = with(density){18.dp.toSp()},
                color = secondary,
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.text_padding))
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
                    color = informationText,
                    modifier = Modifier
                        .padding(end = dimensionResource(id = R.dimen.text_padding))
                        .weight(1f)
                )
            }

            Text(
                text = landmarkInfo.description + "\n",
                maxLines = 2,
                style = MaterialTheme.typography.displaySmall,
                fontSize = with(density){16.dp.toSp()},
                color = informationText,
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.text_padding))
                    .weight(1f)
            )

        }
    }
}