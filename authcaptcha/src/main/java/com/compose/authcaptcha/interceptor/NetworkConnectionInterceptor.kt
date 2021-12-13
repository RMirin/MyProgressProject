package com.compose.authcaptcha.interceptor

import com.compose.authcaptcha.exception.NoInternetException
import com.compose.authcaptcha.service.NetworkService
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(
    private val networkService: NetworkService
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            if (!networkService.isNetworkAvailable) {
                throw NoInternetException(RuntimeException())
            }

            return chain.proceed(chain.request())
        } catch (e: IOException) {
            if (!networkService.isNetworkAvailable) {
                throw NoInternetException(e)
            }

            throw e
        }
    }
}