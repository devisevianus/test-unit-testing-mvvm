package com.devis.base_mvvm.data.source.remote

import com.devis.base_mvvm.core.model.UserMdl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by devis on 03/06/20
 */

interface UserService {

    @GET("/users/{username}")
    suspend fun getUserData(
        @Path("username") username: String
    ): Response<UserMdl>

}