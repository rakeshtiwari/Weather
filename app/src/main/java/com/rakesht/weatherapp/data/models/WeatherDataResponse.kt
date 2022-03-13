package com.rakesht.weatherapp.data.models

import com.google.gson.annotations.SerializedName

data class WeatherDataResponse(val current: Current, val location: Location)

data class Current(
    val condition: Condition,
    val temp_c: Double,
    @SerializedName("feelslike_c")
    val feels_like_c: Double,
    val wind_kph: Double,
    val uv: Double,
    val vis_km: Double,
    val pressure_mb: Double,
    val last_updated: String
)

data class Location(
    val name: String,
    val region: String,
    val country: String
)

data class Condition(val text: String, val icon: String)
