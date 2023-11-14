package abtin.android.zabol.ui.screen

import abtin.android.zabol.resource.landmarksResources
import abtin.android.zabol.ui.model.ActionBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import abtin.android.zabol.ui.theme.ZabolTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZabolTheme {
                Scaffold(
                    topBar = {
                        ActionBar(
                            scope = rememberCoroutineScope(),
                            scaffoldState = rememberScaffoldState(),
                            title = "Welcome to Zabol"
                        )
                    }
                ){
                    Box(
                        modifier = Modifier.padding(it)
                    ){
                        LandmarksListScreen(
                            landmarks = landmarksResources()
                        )
                    }
                }

            }
        }
    }
}