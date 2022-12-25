package com.example.ak7mtprojekt.data

import com.example.ak7mtprojekt.networkdata.NetGeoInfo
import com.example.ak7mtprojekt.networkdata.NetWeatherInfo
import com.example.ak7mtprojekt.networkdata.asDomainModel
import com.example.ak7mtprojekt.uidata.GeoInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo
import com.example.ak7mtprojekt.utils.GeoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(private val database: DBWeatherInfoDatabase) : WeatherRepository {
    override suspend fun insertCity(city: WeatherInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCity(city: WeatherInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun getCities(): List<WeatherInfo> {
        val netCitiesList: List<NetWeatherInfo> = emptyList()
        return netCitiesList.asDomainModel()
    }

    override suspend fun getGeoInfo(cityName: String, limit: Int): List<GeoInfo> {
        val netGeoInfos: List<NetGeoInfo>
        withContext(Dispatchers.IO) {
            netGeoInfos = GeoApi.retrofitService.getGeoInfo(cityName, limit.toString())
        }
        return netGeoInfos.asDomainModel()
    }
}