package com.example.ak7mtprojekt.localdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ak7mtprojekt.uidata.WeatherInfo
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
data class DBWeatherInfo(
    @PrimaryKey val id: Int? = null,
    val cityName: String?,
    val cityState: String?,
    val description: String?,
    val temperatureC: Double?,
    val dateOfFetch: Date? = Date(),
    val lat: Double?,
    val lon: Double?
)

// převod DB modelu do ui modelu
fun List<DBWeatherInfo>.asDomainModel(): List<WeatherInfo> {
    return map {
        WeatherInfo(
            id = it.id,
            cityName = it.cityName,
            cityState = it.cityState,
            description = it.description,
            temperatureC = it.temperatureC,
            dateOfFetch = it.dateOfFetch,
            lat = it.lat,
            lon = it.lon
        )
    }
}
