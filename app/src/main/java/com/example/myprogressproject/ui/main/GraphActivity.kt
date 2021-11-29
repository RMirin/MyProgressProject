package com.example.myprogressproject.ui.main

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.ActivityGraphBinding
import com.tradingview.lightweightcharts.api.chart.models.color.toIntColor
import com.tradingview.lightweightcharts.api.interfaces.SeriesApi
import com.tradingview.lightweightcharts.api.options.models.SeriesOptionsCommon
import com.tradingview.lightweightcharts.api.options.models.layoutOptions
import com.tradingview.lightweightcharts.api.options.models.localizationOptions
import com.tradingview.lightweightcharts.api.series.models.HistogramData
import com.tradingview.lightweightcharts.api.series.models.Time
import com.tradingview.lightweightcharts.api.series.models.WhitespaceData
import com.tradingview.lightweightcharts.runtime.plugins.DateTimeFormat
import com.tradingview.lightweightcharts.runtime.plugins.PriceFormatter
import com.tradingview.lightweightcharts.runtime.plugins.TimeFormatter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraphActivity : AppCompatActivity() {

    lateinit var binding: ActivityGraphBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.chartsView.api.applyOptions {
            layout = layoutOptions {
                backgroundColor = Color.LTGRAY.toIntColor()
                textColor = Color.BLACK.toIntColor()
            }
            localization = localizationOptions {
                locale = "ru-RU"
                priceFormatter = PriceFormatter(template = "{price:#2:#3}$")
                timeFormatter = TimeFormatter(
                    locale = "ru-RU",
                    dateTimeFormat = DateTimeFormat.DATE_TIME
                )
            }
        }

        lateinit var histogramSeries: SeriesApi
        binding.chartsView.api.addHistogramSeries(
            onSeriesCreated = { series ->
                histogramSeries = series
                val data = listOf(
                    HistogramData(Time.BusinessDay(2019, 6, 11), 40.01f),
                    HistogramData(Time.BusinessDay(2019, 6, 12), 52.38f),
                    HistogramData(Time.BusinessDay(2019, 6, 13), 36.30f),
                    HistogramData(Time.BusinessDay(2019, 6, 14), 34.48f),
                    WhitespaceData(Time.BusinessDay(2019, 6, 15)),
                    WhitespaceData(Time.BusinessDay(2019, 6, 16)),
                    HistogramData(Time.BusinessDay(2019, 6, 17), 41.50f),
                    HistogramData(Time.BusinessDay(2019, 6, 18), 34.82f)
                )

                histogramSeries.setData(data)
            }
        )


    }
}
