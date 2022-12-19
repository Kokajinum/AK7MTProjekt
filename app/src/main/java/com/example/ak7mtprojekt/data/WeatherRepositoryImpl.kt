package com.example.ak7mtprojekt.data

import androidx.lifecycle.LiveData
import com.example.ak7mtprojekt.localdata.DBWeatherInfo
import com.example.ak7mtprojekt.networkdata.NetGeoInfo
import com.example.ak7mtprojekt.networkdata.asDomainModel
import com.example.ak7mtprojekt.uidata.GeoInfo
import com.example.ak7mtprojekt.utils.GeoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(private val database: DBWeatherInfoDatabase) : WeatherRepository {
    override suspend fun insertCity(city: DBWeatherInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCity(city: DBWeatherInfo) {
        TODO("Not yet implemented")
    }

    override fun getCities(): List<DBWeatherInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getGeoInfo(cityName: String, limit: Int): List<GeoInfo> {
        val netGeoInfos: List<NetGeoInfo>
        withContext(Dispatchers.IO) {
            netGeoInfos = GeoApi.retrofitService.getGeoInfo(cityName, limit.toString())
        }
        return netGeoInfos.asDomainModel()
    }
}