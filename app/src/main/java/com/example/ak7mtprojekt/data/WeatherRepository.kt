package com.example.ak7mtprojekt.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun insertCity(city: DBWeatherInfo)

    suspend fun deleteCity(city: DBWeatherInfo)

    fun getCities(): LiveData<List<DBWeatherInfo>>

}