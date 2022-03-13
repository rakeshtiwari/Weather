package com.rakesht.weatherapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Weather Data model
 */
@Entity
data class WeatherData(
    val weatherCondition: String,
    val iconUrl: String,
    val visibility: Double,
    val uvIndex: Double,
    val temp: Double,
    val feelsLikeTemp: Double,
    val pressure: Double,
    val windSpeed: Double,
    var lastUpdated: String = "",
    val name: String,
    val region: String,
    val country: String,
    @PrimaryKey
    var query: String = ""
)
