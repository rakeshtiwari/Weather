package com.rakesht.weatherapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rakesht.weatherapp.domain.models.WeatherData

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherData: WeatherData)

    @Query("SELECT * FROM WeatherData WHERE `query` == :q")
    suspend fun loadWeatherData(q: String): WeatherData?
}