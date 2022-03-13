package com.rakesht.weatherapp

import com.rakesht.weatherapp.data.util.isUpdateFromServerNeeded
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

class Util {

    @Test
    fun testIsUpdateFromServerNeeded() {
        assertTrue(isUpdateFromServerNeeded(CURRENT_TIME, SERVER_TIME1))
        assertFalse(isUpdateFromServerNeeded(CURRENT_TIME, SERVER_TIME2))
    }

    private companion object {
        private const val CURRENT_TIME = "2021-09-23 11:16"
        private const val SERVER_TIME1 = "2021-09-23 11:10"
        private const val SERVER_TIME2 = "2021-09-23 11:13"
    }
}