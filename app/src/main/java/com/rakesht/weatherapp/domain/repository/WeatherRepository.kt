package com.rakesht.weatherapp.domain.repository

import com.rakesht.weatherapp.domain.models.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(query: String): WeatherData?
}