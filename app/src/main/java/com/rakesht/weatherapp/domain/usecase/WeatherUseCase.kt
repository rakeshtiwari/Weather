package com.rakesht.weatherapp.domain.usecase

import com.rakesht.weatherapp.domain.models.WeatherData
import com.rakesht.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend fun getWeatherData(query: String): WeatherData? = repository.getWeatherData(query)
}