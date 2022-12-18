package com.example.ak7mtprojekt.uidata

import java.util.*

data class WeatherInfo(
    val id: Int? = null,
    val cityName: String,
    val cityState: String,
    val description: String?,
    val temperatureC: Int,
    val dateOfFetch: Date
)
