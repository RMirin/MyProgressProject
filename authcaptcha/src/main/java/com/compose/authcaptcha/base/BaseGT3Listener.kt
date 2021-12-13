package com.compose.authcaptcha.base

import com.geetest.sdk.GT3ErrorBean
import com.geetest.sdk.GT3Listener

abstract class BaseGT3Listener: GT3Listener() {
    override fun onDialogReady(duration: String?) {
        super.onDialogReady(duration)
    }

    override fun onDialogResult(result: String?) {
        super.onDialogResult(result)
    }

    override fun onReceiveCaptchaCode(p0: Int) {}

    override fun onStatistics(p0: String?) {}

    override fun onClosed(p0: Int) {}

    override fun onSuccess(p0: String?) {}

    override fun onFailed(p0: GT3ErrorBean?) {}
}