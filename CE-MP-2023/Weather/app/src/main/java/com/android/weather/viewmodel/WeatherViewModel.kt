package com.android.weather.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.android.weather.R
import com.android.iranname.landmarks.model.LandmarksDC
import com.android.iranname.landmarks.uitls.LandmarksImagesURI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WeatherViewModel():ViewModel() {

    private val _landmarksList  = MutableStateFlow(emptyList<LandmarksDC>())
    val landmarksList: StateFlow<List<LandmarksDC>> get() = _landmarksList

    private val _loadStatus  = MutableStateFlow("loading")
    val loadStatus:StateFlow<String>  get() = _loadStatus

    fun landmarksProvider(context: Context){
        _landmarksList.value = listOf<LandmarksDC>(
            LandmarksDC(
                name = context.getString(R.string.chogazabil_title),
                image = LandmarksImagesURI.Chogzanbil_First_URI,
                images = listOf(
                    LandmarksImagesURI.Chogzanbil_First_URI,
                    LandmarksImagesURI.Chogzanbil_Second_URI,
                    LandmarksImagesURI.Chogzanbil_Third_URI,
                    LandmarksImagesURI.Chogzanbil_Fourth_URI
                ),
                location = context.getString(R.string.chogazabil_location),
                foundation = context.getString(R.string.chogazabil_foundation),
                description = context.getString(R.string.chogazabil_description),
                comments = null,
                relatedLandmarksDC = null
            ),

            LandmarksDC(
                name = context.getString(R.string.hegmataneh_title),
                image = LandmarksImagesURI.Hegmataneh_First_URI,
                images = listOf(
                    LandmarksImagesURI.Hegmataneh_First_URI,
                    LandmarksImagesURI.Hegmataneh_Second_URI,
                    LandmarksImagesURI.Hegmataneh_Third_URI,
                    LandmarksImagesURI.Hegmataneh_Fourth_URI
                ),
                location = context.getString(R.string.hegmataneh_location),
                foundation = context.getString(R.string.hegmataneh_foundation),
                description = context.getString(R.string.hegmataneh_description),
                comments = null,
                relatedLandmarksDC = null
            ),

            LandmarksDC(
                name = context.getString(R.string.pasargad_title),
                image = LandmarksImagesURI.Pasargad_First_URI,
                images = listOf(
                    LandmarksImagesURI.Pasargad_First_URI,
                    LandmarksImagesURI.Pasargad_Second_URI,
                ),
                location = context.getString(R.string.pasargad_location),
                foundation = context.getString(R.string.pasargad_foundation),
                description = context.getString(R.string.pasargad_description),
                comments = null,
                relatedLandmarksDC = null
            ),

            LandmarksDC(
                name = context.getString(R.string.takhtJamshid_title),
                image = LandmarksImagesURI.TakhtJamshi_First_URI,
                images = listOf(
                    LandmarksImagesURI.TakhtJamshi_First_URI,
                    LandmarksImagesURI.TakhtJamshi_Second_URI,
                    LandmarksImagesURI.TakhtJamshi_Third_URI,
                    LandmarksImagesURI.TakhtJamshi_Fourth_URI
                ),
                location = context.getString(R.string.takhtJamshid_location) ,
                foundation = context.getString(R.string.takhtJamshid_foundation),
                description = context.getString(R.string.takhtJamshid_description),
                comments = null,
                relatedLandmarksDC = null
            ),

            LandmarksDC(
                name = context.getString(R.string.khajo_title),
                image = LandmarksImagesURI.KhajoPol_First_URI,
                images = listOf(
                    LandmarksImagesURI.KhajoPol_First_URI,
                    LandmarksImagesURI.KhajoPol_Second_URI,
                    LandmarksImagesURI.KhajoPol_Third_URI,
                    LandmarksImagesURI.KhajoPol_Fourth_URI
                ),
                location =context.getString(R.string.khajo_location) ,
                foundation = context.getString(R.string.khajo_foundation),
                description = context.getString(R.string.khajo_description),
                comments = null,
                relatedLandmarksDC = null
            ),

            LandmarksDC(
                name = context.getString(R.string.arg_title),
                image = LandmarksImagesURI.Arg_First_URI,
                images = listOf(
                    LandmarksImagesURI.Arg_First_URI,
                    LandmarksImagesURI.Arg_Second_URI,
                    LandmarksImagesURI.Arg_Third_URI,
                    LandmarksImagesURI.Arg_Fourth_URI
                ),
                location = context.getString(R.string.arg_location),
                foundation = context.getString(R.string.arg_foundation),
                description = context.getString(R.string.arg_description),
                comments = null,
                relatedLandmarksDC = null
            )
        )

        _loadStatus.value = "finished"
    }
}