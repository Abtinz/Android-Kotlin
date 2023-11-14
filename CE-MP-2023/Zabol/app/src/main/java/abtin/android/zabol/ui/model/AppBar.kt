package abtin.android.zabol.ui.model

import abtin.android.zabol.ui.theme.primary
import abtin.android.zabol.ui.theme.secondary
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@Composable
fun ActionBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    title: String,
){
    val density = LocalDensity.current
    TopAppBar(

        elevation = 2.dp,
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = primary,
                fontSize = with(density){32.dp.toSp()}
            )
        } ,
        backgroundColor = secondary ,
        contentColor = primary
    )
}