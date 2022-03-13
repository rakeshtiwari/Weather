package com.rakesht.weatherapp.data.service

import com.rakesht.weatherapp.data.models.WeatherDataResponse
import com.rakesht.weatherapp.data.service.EndPoint.ENDPOINT_WEATHER_DATA
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET(ENDPOINT_WEATHER_DATA)
    suspend fun getWeatherData(
        @Query("key") key: String,
        @Query("q") query: String
    ): WeatherDataResponse?
}