package com.rakesht.weatherapp.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakesht.weatherapp.domain.models.WeatherData
import com.rakesht.weatherapp.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase) : ViewModel() {
    var weatherLiveData = MutableLiveData<WeatherData>()

    fun getWeatherData(query: String) = viewModelScope.launch {
        weatherLiveData.value = weatherUseCase.getWeatherData(query)
    }
}