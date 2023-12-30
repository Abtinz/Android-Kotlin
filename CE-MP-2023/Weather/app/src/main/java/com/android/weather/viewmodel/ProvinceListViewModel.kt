package com.android.weather.viewmodel

import androidx.lifecycle.ViewModel
import com.android.weather.model.City
import com.android.weather.model.ProvincesDC

class ProvinceListViewModel():ViewModel() {

    fun provinceResources():List<ProvincesDC>{

        return listOf(

            ProvincesDC(
                name = "تهران",
                cities = listOf(
                    City(
                        name ="تهران",
                        lat = 35.7219,
                        lon = 51.3347,
                    ),
                    City(
                        name ="ورامین ",
                        lat = 35.3252,
                        lon = 51.3252,
                    ),
                    City(
                        name ="شهریار",
                        lat = 35.6544,
                        lon = 51.0600,
                    )
                ),
            ),

            ProvincesDC(
                name = "فارس",
                cities = listOf(
                    City(
                        name ="شیراز",
                        lat = 29.5916,
                        lon = 52.5837,
                    ),
                    City(
                        name ="کازرون ",
                        lat = 29.6172,
                        lon = 51.6172,
                    ),
                    City(
                        name ="مرودشت",
                        lat = 29.8760,
                        lon = 52.8001,
                    )
                ),
            ),

            ProvincesDC(
                name = "خراسان رضوی",
                cities = listOf(
                    City(
                        name ="مشهد",
                        lat = 36.2605,
                        lon = 59.6168,
                    ),
                    City(
                        name ="سبزوار ",
                        lat = 36.2126,
                        lon = 57.6817,
                    ),
                    City(
                        name ="نیشابور",
                        lat = 36.2154,
                        lon =58.7959,
                    )
                ),
            ),

            ProvincesDC(
                name = "اصفهان",
                cities = listOf(
                    City(
                        name ="اصفهان",
                        lat = 32.6546,
                        lon = 51.6679,
                    ),
                    City(
                        name ="کاشان ",
                        lat = 33.9850,
                        lon = 51.4099,
                    ),
                    City(
                        name ="نجف آباد",
                        lat =32.6333,
                        lon =51.3667,
                    )
                ),
            ),

            ProvincesDC(
                name = "گیلان",
                cities = listOf(
                    City(
                        name ="رشت",
                        lat = 37.2807,
                        lon =49.5832,
                    ),
                    City(
                        name ="انزلی ",
                        lat = 37.4711,
                        lon =  49.4623,
                    ),
                    City(
                        name ="لاهیجان",
                        lat =37.2077,
                        lon =50.0031,
                    )
                ),
            )
        )
    }
}