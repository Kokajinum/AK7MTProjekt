package com.example.ak7mtprojekt.utils

import com.example.ak7mtprojekt.networkdata.NetGeoInfo
import com.example.ak7mtprojekt.networkdata.NetWeatherInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_API_KEY =
    "815217e82c9164b2ceba6e0870f6d1b7"

private const val BASE_URL_GEO =
    "https://api.openweathermap.org/geo/1.0/"

private const val BASE_URL_WEATHER =
    "https://api.openweathermap.org/data/2.5/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofitGeo = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_GEO)
    .build()

private val retrofitWeather = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_WEATHER)
    .build()




interface GeoApiService {
    //@GET("direct?q={city}&limit={lim}&appid={id}")
    @GET("direct?")
    suspend fun getGeoInfo(
        @Query("q") city: String,
        @Query("limit") limit: String,
        @Query("appid") id: String = BASE_API_KEY): List<NetGeoInfo>
}

interface WeatherApiService {
    @GET("weather?units=metric&")
    suspend fun getWeatherInfo(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") id: String = BASE_API_KEY): NetWeatherInfo
}

object GeoApi {
    val retrofitService : GeoApiService by lazy {
        retrofitGeo.create(GeoApiService::class.java)
    }
}

object WeatherApi {
    val retrofitService : WeatherApiService by lazy {
        retrofitWeather.create(WeatherApiService::class.java)
    }
}
