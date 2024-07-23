package com.android.object_detection.presentation.camera

import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView

/** This function will load our camera preview
 * @param controller : lifecycleCameraController which will load,manage and ... our camera processes
 * @param modifier: Android view essential modifier
 */
@Composable
fun CameraPreview(
    controller: LifecycleCameraController,
    modifier: Modifier = Modifier
){
    val lifecycleOwner = LocalLifecycleOwner.current

    //camera view, its not ready for jp so we should use AndroidView
    AndroidView(
        factory = {
            //PreviewView is a part of the CameraX library in Android. It's a view that displays the camera's preview stream ...
            PreviewView(it).apply {
                this.controller = controller
                controller.bindToLifecycle(lifecycleOwner)
            }
        },
        modifier = modifier
    )
}

/**
 * What is controller.bindToLifecycle(lifecycleOwner) and why?
 *
 * controller.bindToLifecycle(lifecycleOwner) is a method call that binds the camera controller to the lifecycle of the given lifecycleOwner.
 *     Lifecycle-aware: This ensures that the camera starts and stops based on the lifecycle of the component (like an Activity or Fragment) that owns it.
 *     lifecycleOwner: This is typically an Activity or Fragment that implements the LifecycleOwner interface.
 */