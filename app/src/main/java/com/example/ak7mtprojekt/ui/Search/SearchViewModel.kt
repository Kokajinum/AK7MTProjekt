package com.example.ak7mtprojekt.ui.Search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ak7mtprojekt.data.WeatherRepository
import com.example.ak7mtprojekt.uidata.GeoInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _searchState = MutableStateFlow("")
    val searchState: StateFlow<String> = _searchState

    private val _cities = MutableStateFlow<MutableList<GeoInfo>>(ArrayList())
    val cities: StateFlow<MutableList<GeoInfo>> = _cities

    private val _isFavIconVisible = MutableStateFlow(false)
    val isFavIconVisible: StateFlow<Boolean> = _isFavIconVisible

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading


    fun searchCities() {
        try {
            viewModelScope.launch {
                _isLoading.update { true }
                val qeo = repository.getGeoInfo(_searchState.value, 15).toMutableList()
                _cities.update { qeo }
                _isLoading.update { false }
            }
        }
        catch (e: Exception) {

        }

        val s = listOf(
            WeatherInfo(1, "Praha", "Česká republika", null, temperatureC = 2.0, null, null, null),
            WeatherInfo(2, "Kroměříž", "Česká republika", null, temperatureC = 5.0, null, null, null))


    }

    fun updateSearchQuery(query: String) {
        _searchState.value = query
    }

    fun changeFavIconVisibility() {
        if (_isFavIconVisible.value) {
            _isFavIconVisible.update { false }
        }
        else {
            _isFavIconVisible.update { true }
        }
    }

    fun onCardSelected(geoInfo: GeoInfo) {
        try {
            viewModelScope.launch {
                val weatherInfo = repository.getWeatherInfo(geoInfo.lat, geoInfo.lon)
                repository.insertCity(weatherInfo)
                val updatedCities = _cities.value.filter { !it.equals(geoInfo) }.toMutableList()
                _cities.update { updatedCities }
            }
        }
        catch (e: Exception) {

        }
    }

    fun showLoading() {
        _isLoading.update { true }
    }

    fun clearCities() {
        _cities.update { _cities.value.filter { false }.toMutableList() }
    }
}