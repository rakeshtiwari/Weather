package com.rakesht.weatherapp.domain.usecase

import com.rakesht.weatherapp.BaseTest
import com.rakesht.weatherapp.domain.models.WeatherData
import com.rakesht.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class WeatherUseCaseTest : BaseTest() {
    private lateinit var useCase: WeatherUseCase

    @Mock
    private lateinit var weatherRepository: WeatherRepository

    @Mock
    private lateinit var weatherData: WeatherData

    override fun setup() {
        super.setup()
        useCase = WeatherUseCase(weatherRepository)
    }

    @Test
    fun getWeatherDataTest() {
        runBlocking {
            `when`(useCase.getWeatherData(QUERY)).thenReturn(weatherData)
            val weatherData = useCase.getWeatherData(QUERY)
            assertNotNull(weatherData)
        }
    }

    private companion object {
        private const val QUERY = "test"
    }
}