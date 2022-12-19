package com.example.ak7mtprojekt.data

import androidx.lifecycle.LiveData
import com.example.ak7mtprojekt.localdata.DBWeatherInfo
import com.example.ak7mtprojekt.uidata.GeoInfo

interface WeatherRepository {

    suspend fun insertCity(city: DBWeatherInfo)

    suspend fun deleteCity(city: DBWeatherInfo)

    fun getCities(): List<DBWeatherInfo>

    suspend fun getGeoInfo(cityName: String, limit: Int): List<GeoInfo>

}