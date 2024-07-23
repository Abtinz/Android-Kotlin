package com.android.object_detection.data

import android.content.Context
import android.graphics.Bitmap
import com.android.object_detection.domain.ClassificationResults
import com.android.object_detection.domain.ObjectClassifier
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions
import java.nio.ByteBuffer
import java.nio.ByteOrder

class TensorFlowLiteClassifier(
    private val context: Context,
    private val conf: Float = 0.5f,
    private val count: Int = 3,
    private val threads: Int = 4
) : ObjectClassifier {

    private var interpreter: Interpreter? = null

    private fun setupInterpreter() {
        val modelFile = FileUtil.loadMappedFile(context, "yolo_v5.tflite")
        val options = Interpreter.Options().apply {
            setNumThreads(threads)
        }
        interpreter = Interpreter(modelFile, options)
    }

    override fun getOrientationFromRotation(rotation: Int): ImageProcessingOptions.Orientation {
        // Implement this method if necessary
        return ImageProcessingOptions.Orientation.RIGHT_TOP
    }

    override fun classify(bitmap: Bitmap, rotation: Int): List<ClassificationResults> {
        if (interpreter == null) {
            setupInterpreter()
        }

        val input = preprocessBitmap(bitmap)
        val output = Array(1) { Array(25200) { FloatArray(85) } } // Adjust the dimensions based on your model

        interpreter?.run(input, output)

        return parseOutputs(output)
    }

    private fun preprocessBitmap(bitmap: Bitmap): ByteBuffer {
        val resized = Bitmap.createScaledBitmap(bitmap, 640, 640, true)
        val byteBuffer = ByteBuffer.allocateDirect(4 * 640 * 640 * 3)
        byteBuffer.order(ByteOrder.nativeOrder())

        val pixels = IntArray(640 * 640)
        resized.getPixels(pixels, 0, 640, 0, 0, 640, 640)

        for (pixel in pixels) {
            byteBuffer.putFloat(((pixel shr 16 and 0xFF) - 128f) / 128f)
            byteBuffer.putFloat(((pixel shr 8 and 0xFF) - 128f) / 128f)
            byteBuffer.putFloat(((pixel and 0xFF) - 128f) / 128f)
        }

        return byteBuffer
    }

    private fun parseOutputs(output: Array<Array<FloatArray>>): List<ClassificationResults> {
        val results = mutableListOf<ClassificationResults>()
        for (detection in output[0]) {
            val score = detection[4]
            if (score > conf) {
                val label = detection[5].toInt()
                results.add(ClassificationResults(label.toString(), score))
            }
        }
        return results
    }
}
