package com.android.landmarkdetection.domain

import android.graphics.Bitmap

interface LandmarkClassifier {

    /**
     * Classifies the given bitmap image to identify landmarks.
     *
     * @param bitmap The bitmap image to be processed from the camera view.
     * @param rotation The rotation angle of the image which needs to be corrected before processing.
     * @return A list of classification results, each containing a label and a confidence score.
     */
    fun classify(bitmap: Bitmap, rotation:Int):List<ClassificationResults>
}