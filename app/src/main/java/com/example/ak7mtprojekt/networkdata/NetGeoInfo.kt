package com.example.ak7mtprojekt.networkdata

import com.example.ak7mtprojekt.uidata.GeoInfo

data class NetGeoInfo(
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String,
    val state: String?
)

fun List<NetGeoInfo>.asDomainModel(): List<GeoInfo> {
    return map {
        GeoInfo(
            name = it.name,
            lat = it.lat,
            lon = it.lon,
            country = it.country,
            state = it.state
        )
    }
}