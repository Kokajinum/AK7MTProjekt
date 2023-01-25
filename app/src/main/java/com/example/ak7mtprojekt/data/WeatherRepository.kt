package com.example.ak7mtprojekt.data

import com.example.ak7mtprojekt.uidata.GeoInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo

interface WeatherRepository {

    suspend fun insertCity(city: WeatherInfo)

    suspend fun deleteCity(city: WeatherInfo)

    suspend fun getCities(): List<WeatherInfo>

    suspend fun getGeoInfo(cityName: String, limit: Int): List<GeoInfo>

    suspend fun getWeatherInfo(lat: Double, lon: Double) : WeatherInfo

    suspend fun updateCities(cityList: MutableList<WeatherInfo>) : MutableList<WeatherInfo>
}