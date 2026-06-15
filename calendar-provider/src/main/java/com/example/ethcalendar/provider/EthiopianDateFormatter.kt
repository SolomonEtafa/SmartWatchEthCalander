package com.example.ethcalendar.provider

import android.icu.util.Calendar
import android.icu.util.EthiopicCalendar
import java.util.Date

data class EthiopianDateText(
    val weekday: String,
    val date: String,
)

object EthiopianDateFormatter {
    private val months = arrayOf(
        "መስከረም",
        "ጥቅምት",
        "ኅዳር",
        "ታኅሣሥ",
        "ጥር",
        "የካቲት",
        "መጋቢት",
        "ሚያዝያ",
        "ግንቦት",
        "ሰኔ",
        "ሐምሌ",
        "ነሐሴ",
        "ጳጉሜን",
    )

    private val weekdays = arrayOf(
        "እሑድ",
        "ሰኞ",
        "ማክሰኞ",
        "ረቡዕ",
        "ሐሙስ",
        "ዓርብ",
        "ቅዳሜ",
    )

    fun format(date: Date = Date()): EthiopianDateText {
        val calendar = EthiopicCalendar().apply {
            time = date
        }
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val weekday = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY

        return EthiopianDateText(
            weekday = weekdays[weekday],
            date = "${months[month]} ${toGeezNumber(day)}",
        )
    }

    /**
     * Ethiopian calendar years fit below 10,000 for the foreseeable lifetime
     * of this app, so only the standard ፻ grouping is needed here.
     */
    internal fun toGeezNumber(value: Int): String {
        require(value in 1..9999) { "Ge'ez number must be between 1 and 9999" }

        val hundreds = value / 100
        val remainder = value % 100
        return buildString {
            if (hundreds > 0) {
                if (hundreds != 1) append(belowHundred(hundreds))
                append('፻')
            }
            if (remainder > 0) append(belowHundred(remainder))
        }
    }

    private fun belowHundred(value: Int): String {
        val ones = arrayOf("", "፩", "፪", "፫", "፬", "፭", "፮", "፯", "፰", "፱")
        val tens = arrayOf("", "፲", "፳", "፴", "፵", "፶", "፷", "፸", "፹", "፺")
        return tens[value / 10] + ones[value % 10]
    }
}
