package com.android.object_detection

import android.os.Bundle
import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.object_detection.data.TensorFlowLiteClassifier
import com.android.object_detection.domain.ClassificationResults
import com.android.object_detection.presentation.camera.CameraPreview
import com.android.object_detection.presentation.tensorflow.TensorFlowLiteFrameAnalyzer
import com.android.object_detection.ui.theme.ObjectDetectionTheme
import com.android.object_detection.ui.theme.primary
import com.android.object_detection.ui.theme.secondary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!hasCameraPermission()) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CAMERA), 0
            )
        }
        setContent {
            ObjectDetectionTheme {

                var classifications by remember {
                    mutableStateOf(emptyList<ClassificationResults>())
                }

                val analyzer = remember {
                    TensorFlowLiteFrameAnalyzer(
                        classifier = TensorFlowLiteClassifier(
                            context = applicationContext
                        ),
                        onResults = {
                            classifications = it
                        }
                    )
                }

                val controller = remember {
                    LifecycleCameraController(applicationContext).apply {
                        setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
                        setImageAnalysisAnalyzer(
                            ContextCompat.getMainExecutor(applicationContext),
                            analyzer
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){

                    //we need a camera preview as background
                    CameraPreview(
                        controller = controller,
                        modifier = Modifier.fillMaxSize()
                    )

                    //our final results will be attached to page header
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                    ) {
                        classifications.forEach {
                            Text(
                                text = it.label,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(secondary)
                                    .padding(10.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                color = primary
                            )
                        }
                    }
                }
            }
        }
    }

    private fun hasCameraPermission() = ContextCompat.checkSelfPermission(
        this, Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
}