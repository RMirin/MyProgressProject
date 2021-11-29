package com.example.myprogressproject.ui.crypto.actions

import androidx.annotation.StringRes
import com.example.myprogressproject.R

enum class CryptoAction(
    @StringRes val title: Int
) {
    VERIFICATION(
        R.string.crypto_action_verification
    ),
    GET(
        R.string.crypto_action_get
    ),
    BUY(
        R.string.crypto_action_buy
    ),
    SEND(
        R.string.crypto_action_send
    )
}