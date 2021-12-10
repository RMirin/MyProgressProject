package com.example.core.interceptor

import com.example.core.exception.NoInternetException
import com.example.core.service.NetworkService
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