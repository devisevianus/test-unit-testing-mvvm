package com.devis.base_mvvm.data.source.remote

import com.devis.base_mvvm.core.helper.PrefHelper
import com.devis.base_mvvm.core.model.BaseMdl
import com.devis.base_mvvm.data.source.LoginDataSource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */

class RemoteLoginDataSource @Inject constructor(
    private val apiService: AuthService,
    prefHelper: PrefHelper
) : LoginDataSource {

    val pref = prefHelper

    /*override suspend fun postLogin(requestLoginMdl: RequestLoginMdl): Response<BaseMdl<LoginMdl>> {
        return apiService.postLogin(requestLoginMdl)
    }

    override suspend fun postSocialLogin(requestSocialLoginMdl: RequestSocialLoginMdl): Response<BaseMdl<LoginMdl>> {
        return apiService.postSocialLogin(Constant.APPLICATION_JSON, requestSocialLoginMdl)
    }

    override suspend fun postLogout(requestLoginMdl: RequestLoginMdl): Response<BaseMdl<Nothing>> {
        val auth = "${Constant.BEARER}${pref.getUserLogin()!!.accessToken}"
        return apiService.postLogout(
            Constant.APPLICATION_JSON, auth, requestLoginMdl
        )
    }*/

}