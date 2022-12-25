package com.example.ak7mtprojekt.networkdata

import com.example.ak7mtprojekt.localdata.DBWeatherInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo
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

// převod api modelu do db modelu
fun List<NetWeatherInfo>.asDatabaseModel(): List<DBWeatherInfo> {
    return map {
        DBWeatherInfo(
            id = it.id,
            cityName = it.cityName,
            cityState = it.cityState,
            description = it.description,
            temperatureC = it.temperatureC,
            dateOfFetch = it.dateOfFetch
        )
    }
}

fun List<NetWeatherInfo>.asDomainModel(): List<WeatherInfo> {
    return map {
        WeatherInfo(
            id = it.id,
            cityName = it.cityName,
            cityState = it.cityState,
            description = it.description,
            temperatureC = it.temperatureC,
            dateOfFetch = it.dateOfFetch
        )
    }
}