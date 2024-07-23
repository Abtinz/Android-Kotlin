import android.content.Context
import android.graphics.Bitmap
import com.android.object_detection.domain.ClassificationResults
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import java.nio.ByteBuffer
import java.nio.ByteOrder

class YOLOv5Classifier(context: Context, modelPath: String, private val conf: Float) {
    private val interpreter: Interpreter

    init {
        val modelFile = FileUtil.loadMappedFile(context, modelPath)
        interpreter = Interpreter(modelFile)
    }

    fun classify(bitmap: Bitmap): List<ClassificationResults> {
        val input = preprocessBitmap(bitmap)
        val output = Array(1) { Array(25200) { FloatArray(85) } }

        interpreter.run(input, output)

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
        for (det in output[0]) {
            val score = det[4]
            if (score > conf) {
                val label = det[5].toInt()
                results.add(ClassificationResults(label.toString(), score))
            }
        }
        return results
    }
}
