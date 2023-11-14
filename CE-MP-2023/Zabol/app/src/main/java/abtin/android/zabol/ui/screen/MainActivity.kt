package abtin.android.zabol.ui.screen

import abtin.android.zabol.resource.LandmarksResources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import abtin.android.zabol.ui.theme.ZabolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZabolTheme {
                LandmarksListScreen(
                        landmarks = LandmarksResources()
                )
            }
        }
    }
}