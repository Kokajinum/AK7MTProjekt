package com.example.ak7mtprojekt.utils

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class ApiService {

}

private const val BASE_API_KEY =
    "815217e82c9164b2ceba6e0870f6d1b7"

private const val BASE_URL_GEO =
    "http://api.openweathermap.org/geo/1.0/direct?"

private const val BASE_URL_WEATHER =
    "https://api.openweathermap.org/data/2.5/weather?"

private val retrofitGeo = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL_GEO)
    .build()

private val retrofitWeather = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL_WEATHER)
    .build()

interface MarsApiService {
    @GET("realestate")
    fun getProperties():
            Call<String>
}