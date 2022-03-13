package com.rakesht.weatherapp.data.util

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
private const val FIVE_MIN = 5 * 60 * 1000

/**
 * returns true when last update is more than 5 min ago
 */
fun isUpdateFromServerNeeded(currentTime: String, lastUpdateTime: String): Boolean {
    val currentTimeMillis = (simpleDateFormat.parse(currentTime) as Date).time
    val lastUpdateTimeMillis = (simpleDateFormat.parse(lastUpdateTime) as Date).time
    return lastUpdateTimeMillis + FIVE_MIN < currentTimeMillis
}