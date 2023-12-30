package com.android.weather.network.response

data class AirPollutionResponse(
    val list: List<PollutionItem>
)

data class PollutionItem(
    val dt: Long,
    val main: PollutionMain,
    val components: PollutionComponents
)

data class PollutionMain(
    var aqi: Int
)

data class PollutionComponents(
    val co: Double,
    val no: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    val pm2_5: Double,
    val pm10: Double,
    val nh3: Double
)