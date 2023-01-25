package com.example.ak7mtprojekt.utils

import com.example.ak7mtprojekt.networkdata.NetGeoInfo
import com.example.ak7mtprojekt.networkdata.NetWeatherInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.dnsoverhttps.DnsOverHttps
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.File
import java.net.InetAddress
import java.net.Proxy
import java.net.Proxy.NO_PROXY
import java.util.concurrent.TimeUnit


private const val BASE_API_KEY =
    "815217e82c9164b2ceba6e0870f6d1b7"

private const val BASE_URL_GEO =
    "https://api.openweathermap.org/geo/1.0/"

private const val BASE_URL_WEATHER =
    "https://api.openweathermap.org/data/2.5/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/*
val appCache = Cache(File("cacheDir", "okhttpcache"), 10 * 1024 * 1024)
val bootstrapClient = OkHttpClient.Builder()
    .cache(appCache)
    .proxy(Proxy.NO_PROXY)
    .build()
val dns = DnsOverHttps.Builder()
    .client(bootstrapClient)
    .url("https://dns.google/dns-query".toHttpUrl())
    .bootstrapDnsHosts(InetAddress.getByName("8.8.4.4"), InetAddress.getByName("8.8.8.8"))
    .build()
val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(2, TimeUnit.SECONDS)
    .readTimeout(2, TimeUnit.SECONDS)
    .writeTimeout(2, TimeUnit.SECONDS)
    .dns(dns)
    .proxy(NO_PROXY)
    .build()
*/

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

/*object GeoApi {
    val retrofitService : GeoApiService by lazy {
        retrofitGeo.create(GeoApiService::class.java)
    }
}*/

object GeoApi {
    val retrofitService: GeoApiService = retrofitGeo.create(GeoApiService::class.java)
    }

/*object WeatherApi {
    val retrofitService : WeatherApiService by lazy {
        retrofitWeather.create(WeatherApiService::class.java)
    }
}*/

object WeatherApi {
    val retrofitService : WeatherApiService = retrofitWeather.create(WeatherApiService::class.java)
    }
