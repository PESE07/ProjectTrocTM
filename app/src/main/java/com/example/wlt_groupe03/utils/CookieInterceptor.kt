package com.example.wlt_groupe03.utils

import okhttp3.Interceptor
import okhttp3.Response

class CookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val cookie = RetrofitHelper.getAuthCookie()
        val originalRequest  = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .addHeader("Cookie", "AUTH_COOKIE=${cookie}")
            .build()
        return chain.proceed(modifiedRequest)
    }
}