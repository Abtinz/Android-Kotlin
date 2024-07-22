package com.android.landmarkdetection.data

import android.content.Context
import android.graphics.Bitmap
import android.view.Surface
import com.android.landmarkdetection.domain.ClassificationResults
import com.android.landmarkdetection.domain.LandmarkClassifier
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions
import org.tensorflow.lite.task.vision.classifier.ImageClassifier

class TensorFlowLiteClassifier(
    private val context: Context,
    private val conf: Float = 0.5f,
    private val count: Int = 1,
    private val threads: Int = 2,
) :LandmarkClassifier{

    private var classifier: ImageClassifier? = null

    private fun setupClassifier() {

        //basic options like threads counts or gpu usage
        val baseOptions = BaseOptions.builder()
            .setNumThreads(threads)
            .build()

        //other options of an image classifier like threads setMaxResults or setScoreThreshold (we have to set baseOptions here too)
        val options = ImageClassifier.ImageClassifierOptions.builder()
            .setBaseOptions(baseOptions)
            .setMaxResults(count)
            .setScoreThreshold(conf)
            .build()

        try {
            classifier = ImageClassifier.createFromFileAndOptions(
                context,
                "landmarks_detector.tflite",
                options
            )
        } catch (error: IllegalStateException) {
            error.printStackTrace()
        }
    }

    override fun getOrientationFromRotation(rotation: Int): ImageProcessingOptions.Orientation {
        return when(rotation) {
            Surface.ROTATION_270 -> ImageProcessingOptions.Orientation.BOTTOM_RIGHT
            Surface.ROTATION_90 -> ImageProcessingOptions.Orientation.TOP_LEFT
            Surface.ROTATION_180 -> ImageProcessingOptions.Orientation.RIGHT_BOTTOM
            else -> ImageProcessingOptions.Orientation.RIGHT_TOP
        }
    }

    override fun classify(bitmap: Bitmap, rotation: Int): List<ClassificationResults> {

        //initialization of classifier
        if(classifier == null) {
            setupClassifier()
        }


    }



}