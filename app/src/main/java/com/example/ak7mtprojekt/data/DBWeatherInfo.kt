package com.example.ak7mtprojekt.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class DBWeatherInfo(
    @PrimaryKey val id: Int? = null,
    val cityName: String,
    val cityState: String,
    val description: String?,
    val temperatureC: Int,
    val dateOfFetch: Date
)
