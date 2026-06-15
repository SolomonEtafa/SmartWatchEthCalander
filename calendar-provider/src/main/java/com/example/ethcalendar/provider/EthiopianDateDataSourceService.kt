package com.example.ethcalendar.provider

import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.LongTextComplicationData
import androidx.wear.watchface.complications.data.NoDataComplicationData
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService

class EthiopianDateDataSourceService : SuspendingComplicationDataSourceService() {
    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData {
        if (request.complicationType != ComplicationType.LONG_TEXT) {
            return NoDataComplicationData()
        }
        return createData()
    }

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        if (type != ComplicationType.LONG_TEXT) return null
        return createData()
    }

    private fun createData(): ComplicationData {
        val formatted = EthiopianDateFormatter.format()
        return LongTextComplicationData.Builder(
            text = PlainComplicationText.Builder(formatted.date).build(),
            contentDescription = PlainComplicationText.Builder(
                "${formatted.weekday}, ${formatted.date}",
            ).build(),
        )
            .build()
    }
}
