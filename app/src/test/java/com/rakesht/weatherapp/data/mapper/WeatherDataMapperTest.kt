package com.rakesht.weatherapp.data.mapper

import com.rakesht.weatherapp.data.models.WeatherDataResponse
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Scanner

class WeatherDataMapperTest {
    private lateinit var mapper: WeatherDataMapper
    private val gson = Gson()

    @Before
    fun setup() {
        mapper = WeatherDataMapper()
    }

    @Test
    fun mapToEntityFromDtoTest() {
        val weatherDataResponse: WeatherDataResponse =
            gson.fromJson(
                getJson(WEATHER_DATA_RESPONSE),
                WeatherDataResponse::class.java
            )

        val weatherData = mapper.mapToEntityFromDto(weatherDataResponse)
        assertEquals(weatherData?.name, weatherDataResponse.location.name)
        assertEquals(weatherData?.country, weatherDataResponse.location.country)
        assertEquals(weatherData?.region, weatherDataResponse.location.region)
        assertEquals(weatherData?.feelsLikeTemp, weatherDataResponse.current.feels_like_c)
        assertEquals(weatherData?.temp, weatherDataResponse.current.temp_c)
        assertEquals(weatherData?.iconUrl, "https:" + weatherDataResponse.current.condition.icon)
        assertEquals(weatherData?.weatherCondition, weatherDataResponse.current.condition.text)
    }

    private fun getJson(path: String): String {
        return Scanner(WeatherDataMapperTest::class.java.getResourceAsStream("/json$path")).useDelimiter(
            "\\Z"
        ).next()
    }

    private companion object {
        private const val WEATHER_DATA_RESPONSE = "/WeatherDataResponse.json"
    }
}