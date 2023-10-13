package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.screen.info.PersonalInformationCardView
import com.example.businesscard.ui.screen.skills.PersonalSkills
import com.example.businesscard.ui.theme.BackgroundColor
import com.example.businesscard.ui.theme.CardsBackGround

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           BusinessCardView()
        }
    }
}

@Composable
fun BusinessCardView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor),
        contentAlignment = Alignment.Center
    ){
        var rotated by remember {
            mutableStateOf(false)
        }

        val rotation by animateFloatAsState(
            targetValue = if (rotated) 180f else 0f,
            animationSpec = tween(500),
            label = ""
        )

        val animateFront by animateFloatAsState(
            targetValue = if (!rotated) 1f else 0f,
            animationSpec = tween(500),
            label = ""
        )

        val animateBack by animateFloatAsState(
            targetValue = if (rotated) 1f else 0f,
            animationSpec = tween(500), label = ""
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(start = 35.dp, end = 35.dp)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 8 * density
                },
            backgroundColor = CardsBackGround,
            shape = RoundedCornerShape(0.dp),
            elevation  = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        alpha = if (rotated) animateBack else animateFront
                        rotationY = rotation
                    },
                contentAlignment = Alignment.Center
            ){
                if(!rotated){
                    PersonalInformationCardView(
                        rotationClick = {
                            rotated = true
                        }
                    )
                }else{
                    PersonalSkills(
                        rotationClick = {
                            rotated = false
                        }
                    )
                }
            }
        }

    }
}