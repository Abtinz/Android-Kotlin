package abtin.android.zabol.resource

import abtin.android.zabol.model.Landmarks
import abtin.android.zabol.utils.LandmarksDescription.GhulamanPass_Description
import abtin.android.zabol.utils.LandmarksDescription.JalalabadCitadelofZabol_Description
import abtin.android.zabol.utils.LandmarksDescription.MohammadHosseinKhanCitadel_Description
import abtin.android.zabol.utils.LandmarksDescription.QalehChehelDokhtaran_Description
import abtin.android.zabol.utils.LandmarksDescription.QalehMochi_Description
import abtin.android.zabol.utils.LandmarksDescription.QalehRostam_Description
import abtin.android.zabol.utils.LandmarksDescription.QalehSehKoohe_Description
import abtin.android.zabol.utils.LandmarksDescription.SAHRSOOKHTEH_Description
import abtin.android.zabol.utils.LandmarksImagesURI.GhulamanPass_IMG
import abtin.android.zabol.utils.LandmarksImagesURI.JalalabadCitadelofZabol_IMG
import abtin.android.zabol.utils.LandmarksImagesURI.MohammadHosseinKhanCitadel_IMG
import abtin.android.zabol.utils.LandmarksImagesURI.QalehChehelDokhtaran_IMG
import abtin.android.zabol.utils.LandmarksImagesURI.QalehMochi_IMG
import abtin.android.zabol.utils.LandmarksImagesURI.QalehRostam_IMG
import abtin.android.zabol.utils.LandmarksImagesURI.QalehSehKoohe_IMG
import abtin.android.zabol.utils.LandmarksImagesURI.SAHRSOOKHTEH_IMG
import abtin.android.zabol.utils.LandmarksLocation.GhulamanPass_Location
import abtin.android.zabol.utils.LandmarksLocation.JalalabadCitadelofZabol_Location
import abtin.android.zabol.utils.LandmarksLocation.MohammadHosseinKhanCitadel_Location
import abtin.android.zabol.utils.LandmarksLocation.QalehChehelDokhtaran_Location
import abtin.android.zabol.utils.LandmarksLocation.QalehMochi_Location
import abtin.android.zabol.utils.LandmarksLocation.QalehRostam_Location
import abtin.android.zabol.utils.LandmarksLocation.QalehSehKoohe_Location
import abtin.android.zabol.utils.LandmarksLocation.SAHRSOOKHTEH_Location
import abtin.android.zabol.utils.LandmarksTitle.GhulamanPass_TITLE
import abtin.android.zabol.utils.LandmarksTitle.JalalabadCitadelofZabol_TITLE
import abtin.android.zabol.utils.LandmarksTitle.MohammadHosseinKhanCitadel_TITLE
import abtin.android.zabol.utils.LandmarksTitle.QalehChehelDokhtaran_TITLE
import abtin.android.zabol.utils.LandmarksTitle.QalehMochi_TITLE
import abtin.android.zabol.utils.LandmarksTitle.QalehRostam_TITLE
import abtin.android.zabol.utils.LandmarksTitle.QalehSehKoohe_TITLE
import abtin.android.zabol.utils.LandmarksTitle.SAHRSOOKHTEH_TITLE

fun landmarksResources():List<Landmarks>{
    return listOf(
            Landmarks(
                    image = SAHRSOOKHTEH_IMG,
                    name = SAHRSOOKHTEH_TITLE,
                    description = SAHRSOOKHTEH_Description,
                    location =SAHRSOOKHTEH_Location
            ),

            Landmarks(
                    image = QalehRostam_IMG,
                    name = QalehRostam_TITLE,
                    description = QalehRostam_Description,
                    location =QalehRostam_Location
            ),

            Landmarks(
                    image = JalalabadCitadelofZabol_IMG,
                    name = JalalabadCitadelofZabol_TITLE,
                    description = JalalabadCitadelofZabol_Description,
                    location =JalalabadCitadelofZabol_Location
            ),

            Landmarks(
                    image = GhulamanPass_IMG,
                    name = GhulamanPass_TITLE,
                    description = GhulamanPass_Description,
                    location =GhulamanPass_Location
            ),

            Landmarks(
                    image = QalehSehKoohe_IMG,
                    name = QalehSehKoohe_TITLE,
                    description = QalehSehKoohe_Description,
                    location =QalehSehKoohe_Location
            ),


            Landmarks(
                    image = QalehChehelDokhtaran_IMG,
                    name = QalehChehelDokhtaran_TITLE,
                    description = QalehChehelDokhtaran_Description,
                    location =QalehChehelDokhtaran_Location
            ),

            Landmarks(
                    image = QalehMochi_IMG,
                    name = QalehMochi_TITLE,
                    description = QalehMochi_Description,
                    location =QalehMochi_Location
            ),

            Landmarks(
            image = MohammadHosseinKhanCitadel_IMG,
            name = MohammadHosseinKhanCitadel_TITLE,
            description = MohammadHosseinKhanCitadel_Description,
            location =MohammadHosseinKhanCitadel_Location
        )
    )
}