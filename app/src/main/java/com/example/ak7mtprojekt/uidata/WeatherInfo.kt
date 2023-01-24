package com.example.ak7mtprojekt.uidata

import com.example.ak7mtprojekt.localdata.DBWeatherInfo
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

fun WeatherInfo.asDatabaseModel(): DBWeatherInfo {
    return DBWeatherInfo(
        this.id,
        this.cityName,
        this.cityState,
        this.description,
        this.temperatureC,
        this.dateOfFetch,
        this.lat,
        this.lon
    )
}