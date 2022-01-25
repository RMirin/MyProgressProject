package com.example.recaptcha.response

import com.google.gson.annotations.SerializedName

data class RecaptchaVerifyResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("challenge_ts") var timestamp: String,
    @SerializedName("hostname") var hostName: String
)