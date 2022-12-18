package com.example.ak7mtprojekt.utils

import com.example.ak7mtprojekt.data.DBWeatherInfo
import com.example.ak7mtprojekt.networkdata.NetWeatherInfoContainer
import com.example.ak7mtprojekt.uidata.WeatherInfo

class ConvertHelper {



}

// převod DB modelu do ui modelu
fun List<DBWeatherInfo>.asDomainModel(): List<WeatherInfo> {
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

fun NetWeatherInfoContainer.asDomainModel(): List<WeatherInfo> {
    return videos.map {
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

fun NetWeatherInfoContainer.asDatabaseModel() : List<DBWeatherInfo> {
    return videos.map {
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