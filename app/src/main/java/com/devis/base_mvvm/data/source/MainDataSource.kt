package com.devis.base_mvvm.data.source

import com.devis.base_mvvm.core.model.UserMdl
import com.devis.base_mvvm.data.utils.ResultState
import retrofit2.Response

/**
 * Created by devis on 03/06/20
 */

interface MainDataSource {
    suspend fun getUserData(username: String): ResultState<UserMdl>
}