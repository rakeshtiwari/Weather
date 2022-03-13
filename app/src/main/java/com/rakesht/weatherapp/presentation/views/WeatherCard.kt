package com.rakesht.weatherapp.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.rakesht.weatherapp.R
import com.rakesht.weatherapp.databinding.WeatherCardBinding
import com.rakesht.weatherapp.domain.models.WeatherData
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

/**
 * Weather card view, shows all weather info
 */
class WeatherCard constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs, 0) {

    private val binding = WeatherCardBinding.inflate(LayoutInflater.from(context), this, true)
    private val tempFormat = DecimalFormat("#.#")

    fun setWeatherData(data: WeatherData) {
        binding.apply {
            tvLocation.text = if (data.region.isEmpty()) String.format(
                context.getString(R.string.location), data.name, data.country
            ) else String.format(
                context.getString(R.string.location_r), data.name, data.region, data.country
            )
            Picasso.get().load(data.iconUrl).resize(IMAGE_SIZE, IMAGE_SIZE).into(weatherImg)
            tvWeatherCondition.text = data.weatherCondition
            tvTemperature.text = String.format(
                context.getString(R.string.temp),
                tempFormat.format(data.feelsLikeTemp)
            )
            tvFeelsLike.text = String.format(
                context.getString(R.string.feels_like),
                tempFormat.format(data.feelsLikeTemp)
            )
            tvPressure.text = String.format(
                context.getString(R.string.pressure),
                tempFormat.format(data.pressure)
            )
            tvWindSpeed.text = String.format(
                context.getString(R.string.wind_speed),
                tempFormat.format(data.windSpeed)
            )
            tvVisibility.text = String.format(
                context.getString(R.string.visibility),
                tempFormat.format(data.visibility)
            )
            tvUV.text = String.format(
                context.getString(R.string.uv_index),
                tempFormat.format(data.uvIndex)
            )
            tvLastUpdated.text = String.format(
                context.getString(R.string.last_updated), data.lastUpdated
            )
        }
    }

    private companion object {
        private const val IMAGE_SIZE = 150
    }
}
