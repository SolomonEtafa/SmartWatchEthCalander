package com.example.ethcalendar.provider

import org.junit.Assert.assertEquals
import org.junit.Test

class GeezNumberTest {
    @Test
    fun convertsCommonCalendarValues() {
        assertEquals("፩", EthiopianDateFormatter.toGeezNumber(1))
        assertEquals("፴", EthiopianDateFormatter.toGeezNumber(30))
        assertEquals("፻", EthiopianDateFormatter.toGeezNumber(100))
        assertEquals("፳፻፲፰", EthiopianDateFormatter.toGeezNumber(2018))
    }
}
