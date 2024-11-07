package com.cristiandev.testeempregopetz.data.api

import com.cristiandev.testeempregopetz.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requisicaoBuilder = chain.request().newBuilder()
        requisicaoBuilder.addHeader(
            "X-RapidAPI-Key", BuildConfig.API_KEY
        )
        requisicaoBuilder.addHeader(
            "X-RapidAPI-Host", BuildConfig.API_HOST
        )
        return chain.proceed( requisicaoBuilder.build() )
    }
}