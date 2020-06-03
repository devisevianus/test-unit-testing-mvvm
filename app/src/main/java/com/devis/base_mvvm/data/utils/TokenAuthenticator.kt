package com.devis.base_mvvm.data.utils

import com.devis.base_mvvm.core.helper.PrefHelper
import com.devis.base_mvvm.data.source.remote.AuthService
import com.google.gson.Gson
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */

class TokenAuthenticator @Inject constructor(
    val prefHelper: PrefHelper,
    val authService: AuthService
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        if (authService == null) {
            return null
        }

        //val refreshToken = prefHelper.getUserLogin()?.refreshedToken

        //val retrofitResponse = authService.refreshToken("application/json", RequestRefreshTokenMdl(refreshToken)).execute()

        /*if (retrofitResponse != null) {
            if (retrofitResponse.isSuccessful) {
                val refreshResponse = retrofitResponse.body()
                val newRefreshToken = refreshResponse?.data?.refreshedToken
                val newAccessToken = refreshResponse?.data?.accessToken
                val newId = refreshResponse?.data?.id
                val newName = refreshResponse?.data?.name
                val newStickmart = refreshResponse?.data?.stickMart
                val newFirstLogin = refreshResponse?.data?.first_login
                prefHelper.saveUserLogin(LoginMdl(
                    accessToken = newAccessToken!!,
                    refreshedToken = newRefreshToken!!,
                    id = newId,
                    name = newName!!,
                    stickMart = newStickmart,
                    first_login = newFirstLogin
                ))

                Gson().toJson(refreshResponse.data).loge("refreshToken")
                return response.request().newBuilder()
                    .header("Authorization", "access token")
                    .header("Accept", "application/json")
                    .build()
            }
        }*/

        return null
    }

}