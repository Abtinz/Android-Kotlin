package com.android.object_detection.domain

import android.graphics.Bitmap
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions

interface ObjectClassifier {

    /**
     * Classifies the given bitmap image to identify landmarks.
     *
     * @param bitmap The bitmap image to be processed from the camera view.
     * @param rotation The rotation angle of the image which needs to be corrected before processing.
     * @return A list of classification results, each containing a label and a confidence score.
     */
    fun classify(bitmap: Bitmap, rotation:Int):List<ClassificationResults>

    fun getOrientationFromRotation(rotation: Int): ImageProcessingOptions.Orientation
}