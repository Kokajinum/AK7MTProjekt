package com.example.ak7mtprojekt.utils

import com.example.ak7mtprojekt.localdata.DBWeatherInfo
import com.example.ak7mtprojekt.networkdata.NetGeoInfo
import com.example.ak7mtprojekt.networkdata.NetWeatherInfo
import com.example.ak7mtprojekt.networkdata.NetWeatherInfoContainer
import com.example.ak7mtprojekt.uidata.GeoInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo

class ConvertHelper {



}



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