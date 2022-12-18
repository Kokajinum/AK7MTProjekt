package com.example.ak7mtprojekt.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class WeatherRepositoryImpl(private val database: DBWeatherInfoDatabase) : WeatherRepository {
    override suspend fun insertCity(city: DBWeatherInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCity(city: DBWeatherInfo) {
        TODO("Not yet implemented")
    }

    override fun getCities(): LiveData<List<DBWeatherInfo>> {
        TODO("Not yet implemented")
    }
}