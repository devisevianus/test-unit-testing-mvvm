package com.devis.base_mvvm.data.utils

import com.devis.base_mvvm.core.helper.PrefHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */

class AuthInterceptor @Inject constructor(
    val prefHelper: PrefHelper
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authorizedRequestBuilder = originalRequest.newBuilder()
            .addHeader("Authorization", "access token")
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(authorizedRequestBuilder)
    }

}