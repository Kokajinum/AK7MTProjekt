package com.example.ak7mtprojekt.data

import com.example.ak7mtprojekt.uidata.GeoInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo

interface WeatherRepository {

    suspend fun insertCity(city: WeatherInfo)

    suspend fun deleteCity(city: WeatherInfo)

    suspend fun getCities(): List<WeatherInfo>

    suspend fun getGeoInfo(cityName: String, limit: Int): List<GeoInfo>

}