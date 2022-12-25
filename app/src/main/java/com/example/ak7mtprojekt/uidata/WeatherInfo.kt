package com.example.ak7mtprojekt.uidata

import java.time.LocalDate
import java.util.*

data class WeatherInfo(
    val id: Int? = null,
    val cityName: String?,
    val cityState: String?,
    val description: String?,
    val temperatureC: Double?,
    val dateOfFetch: Date?,
    val lat: Double?,
    val lon: Double?,
)
