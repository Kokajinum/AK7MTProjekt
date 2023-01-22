package com.example.ak7mtprojekt.ui.Overview

import androidx.lifecycle.ViewModel
import com.example.ak7mtprojekt.data.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    val cities = MutableStateFlow(listOf(
        City("New York", "Sunny", "20"),
        City("Los Angeles", "Cloudy", "22"),
        City("Chicago", "Rainy", "18"),
        City("Houston", "Thunderstorms", "25")
    ))
}

data class City(val name: String, val weather: String, val temperature: String)
