package com.example.ak7mtprojekt.ui.Overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ak7mtprojekt.data.WeatherRepository
import com.example.ak7mtprojekt.uidata.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _isInitializing = MutableStateFlow(true)
    val isInitializing: StateFlow<Boolean> = _isInitializing

    private val _cities = MutableStateFlow<MutableList<WeatherInfo>>(ArrayList())
    val cities: StateFlow<MutableList<WeatherInfo>> = _cities

    init {
        GetWeatherData()
    }

    fun GetWeatherData() {
        try {
            viewModelScope.launch {
                _cities.update { repository.getCities().toMutableList() }
                _isInitializing.value = false
            }

        }
        catch (e: Exception) {

        }
    }
}

data class City(val name: String, val weather: String, val temperature: String)
