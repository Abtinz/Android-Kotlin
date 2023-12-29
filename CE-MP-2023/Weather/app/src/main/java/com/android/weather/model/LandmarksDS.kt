package com.android.iranname.landmarks.model

import com.android.weather.commonServices.model.Location

/** this data call will save Landmarks information
 * @param image uri of landmark image
 * @param name name of landmark
 * @param description two or three lines about landmark
 * @param location location of the landmark
 * @param foundation data of construction of this landmark
 * @param comments list of reviews of this landmark
 * @param relatedLandmarksDC list of similar landmarks
 */
data class LandmarksDC(
    val image:String,
    val images:List<String>,
    val name:String,
    val description:String,
    val location:String,
    val foundation:String,
    val comments:List<Location>?,
    val relatedLandmarksDC: List<LandmarksDC>?
)
