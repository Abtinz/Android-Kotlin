package com.android.object_detection.domain

/**
 * Data class to represent the results of a classification operation.
 *
 * @property label The label or category assigned by the classification algorithm.
 * @property score The confidence score or probability associated with the label.
 */
data class ClassificationResults(
    val label: String,
    val score: Float
)
