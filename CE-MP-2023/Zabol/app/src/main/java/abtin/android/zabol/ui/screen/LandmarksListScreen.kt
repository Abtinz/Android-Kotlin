package abtin.android.zabol.ui.screen

import abtin.android.zabol.model.Landmarks
import abtin.android.zabol.ui.theme.mainBackGround
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LandmarksListScreen(landmarks :List<Landmarks>) {
    LazyColumn(
        Modifier.background(color = mainBackGround)
    ){
        items( landmarks){ it ->
            LandmarksCardView(
                landmarkInfo = it
            )
        }
    }
}