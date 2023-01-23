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

    private val _cities = MutableStateFlow<List<GeoInfo>>(emptyList())
    val cities: StateFlow<List<GeoInfo>> = _cities

    private val _isFavIconVisible = MutableStateFlow(false)
    val isFavIconVisible: StateFlow<Boolean> = _isFavIconVisible

    fun searchCities() {
        try {
            viewModelScope.launch {
                val qeo = repository.getGeoInfo(_searchState.value, 5)
                _cities.update { qeo }
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

    fun saveCity() {

    }

    fun getWeather() {

    }
}