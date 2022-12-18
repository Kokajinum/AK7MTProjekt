package com.example.ak7mtprojekt.networkdata

import java.util.*

data class NetWeatherInfo(
    val id: Int? = null,
    val cityName: String,
    val cityState: String,
    val description: String?,
    val temperatureC: Int,
    val dateOfFetch: Date
)

data class NetWeatherInfoContainer(
    val videos: List<NetWeatherInfo>
)
