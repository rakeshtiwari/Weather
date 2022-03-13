package com.rakesht.weatherapp.data.mapper

import com.rakesht.weatherapp.data.models.WeatherDataResponse
import com.rakesht.weatherapp.domain.models.WeatherData
import javax.inject.Inject

class WeatherDataMapper @Inject constructor() : BaseMapper<WeatherDataResponse, WeatherData> {

    override fun mapToEntityFromDto(data: WeatherDataResponse?) = data?.current?.let {
        WeatherData(
            weatherCondition = it.condition.text,
            temp = it.temp_c,
            feelsLikeTemp = it.feels_like_c,
            pressure = it.pressure_mb,
            uvIndex = it.uv,
            visibility = it.vis_km,
            iconUrl = "https:" + it.condition.icon,
            windSpeed = it.wind_kph,
            name = data.location.name,
            region = data.location.region,
            country = data.location.country
        )
    }
}