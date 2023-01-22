package com.example.ak7mtprojekt.ui.Search

import androidx.lifecycle.ViewModel
import com.example.ak7mtprojekt.data.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {


}