package com.rakesht.weatherapp.data.source

import com.rakesht.weatherapp.data.models.WeatherDataResponse
import com.rakesht.weatherapp.data.service.APIService
import com.rakesht.weatherapp.data.service.EndPoint.API_KEY
import com.rakesht.weatherapp.data.service.EndPoint.ENDPOINT_WEATHER_DATA
import javax.inject.Inject

class WeatherDataSource @Inject constructor(
    private val apiService: APIService
) {
    suspend fun getWeatherData(query: String): WeatherDataResponse? =
        apiService.getWeatherData(API_KEY, query)
}