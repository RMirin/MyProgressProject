package com.example.myprogressproject.ui.crypto.filter

import androidx.annotation.StringRes
import com.example.myprogressproject.R

enum class FilterAction(
    @StringRes val title: Int
) {
    BALANCE(
        R.string.bottom_sheet_filter_balance
    ),
    POPULAR(
        R.string.bottom_sheet_filter_popular
    ),
    TOP(
        R.string.bottom_sheet_filter_top
    ),
    GROWTH(
        R.string.bottom_sheet_filter_growth
    ),
    LOSS(
        R.string.bottom_sheet_filter_loss
    ),
    CAPITALIZATION(
        R.string.bottom_sheet_filter_capitalization
    )
}