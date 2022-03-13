package com.rakesht.weatherapp.presentation.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rakesht.weatherapp.databinding.ActivityHomeBinding
import com.rakesht.weatherapp.presentation.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.view.Menu
import com.rakesht.weatherapp.R
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref =
            getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        initWeatherDataObserver()
        sharedPref.getString(QUERY, "auto:ip")?.let { getWeatherData(it) }
    }

    private fun getWeatherData(query: String) {
        sharedPref.edit().putString(QUERY, query).apply()
        binding.progressBar.visibility = VISIBLE
        homeViewModel.getWeatherData(query)
    }

    private fun initWeatherDataObserver() {
        homeViewModel.weatherLiveData.observe(this) { weatherData ->
            binding.progressBar.visibility = GONE
            if (weatherData != null)
                binding.weatherCard.setWeatherData(weatherData)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.location_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val query = when (item.itemId) {
            R.id.london -> "london"
            R.id.sydney -> "sydney"
            R.id.newyork -> "new york"
            R.id.bangalore -> "bangalore"
            R.id.kolkata -> "kolkata"
            else -> "auto:ip"
        }
        getWeatherData(query)
        return true
    }

    private companion object {
        private const val QUERY = "query"
    }
}