package com.example.ak7mtprojekt.data

import com.example.ak7mtprojekt.localdata.DBWeatherInfo
import com.example.ak7mtprojekt.localdata.asDomainModel
import com.example.ak7mtprojekt.networkdata.NetGeoInfo
import com.example.ak7mtprojekt.networkdata.NetWeatherInfo
import com.example.ak7mtprojekt.networkdata.asDomainModel
import com.example.ak7mtprojekt.uidata.GeoInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo
import com.example.ak7mtprojekt.uidata.asDatabaseModel
import com.example.ak7mtprojekt.utils.GeoApi
import com.example.ak7mtprojekt.utils.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(private val database: DBWeatherInfoDatabase) : WeatherRepository {
    override suspend fun insertCity(city: WeatherInfo) {
        val dbWeatherInfo: DBWeatherInfo = city.asDatabaseModel()
        database.cityWeatherDao.insertCity(dbWeatherInfo)
    }

    override suspend fun deleteCity(city: WeatherInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun getCities(): List<WeatherInfo> {
        var DBCitiesList: List<DBWeatherInfo> = emptyList()
        withContext(Dispatchers.IO) {
            DBCitiesList = database.cityWeatherDao.getCities()
        }
        return DBCitiesList.asDomainModel()
    }

    override suspend fun updateCities(cityList: MutableList<WeatherInfo>): MutableList<WeatherInfo> {
        var updatedCityList: MutableList<WeatherInfo> = ArrayList()
        withContext(Dispatchers.IO) {
            cityList.forEach {
                var updatedCity: WeatherInfo = WeatherApi.retrofitService.getWeatherInfo(
                    it.lat.toString(),
                    it.lon.toString()).asDomainModel()

                updatedCityList.add(updatedCity)
                insertCity(updatedCity)
            }
        }
        return updatedCityList
    }

    override suspend fun getGeoInfo(cityName: String, limit: Int): List<GeoInfo> {
        var netGeoInfos: List<NetGeoInfo>
        withContext(Dispatchers.IO) {
            netGeoInfos = GeoApi.retrofitService.getGeoInfo(cityName, limit.toString())
        }
        return netGeoInfos.asDomainModel()
    }

    override suspend fun getWeatherInfo(lat: Double, lon: Double): WeatherInfo {
        var netWeatherInfo: NetWeatherInfo
        withContext(Dispatchers.IO) {
            netWeatherInfo = WeatherApi.retrofitService.getWeatherInfo(lat.toString(), lon.toString())
        }
        return netWeatherInfo.asDomainModel()
    }
}