package com.devis.base_mvvm.data.source.remote

import com.devis.base_mvvm.core.model.UserMdl
import com.devis.base_mvvm.data.source.MainDataSource
import com.devis.base_mvvm.data.utils.ResultState
import com.devis.base_mvvm.data.utils.fetchState
import com.devis.base_mvvm.data.utils.handleError
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */
 
class RemoteMainDataSource @Inject constructor(
    private val apiService: UserService
) : MainDataSource {

    override suspend fun getUserData(username: String): ResultState<UserMdl> {
        return fetchState {
            val response = apiService.getUserData(username)
            if (response.isSuccessful) {
                ResultState.Success(response.body())
            } else {
                ResultState.Error(response.message())
                //ResultState.ErrorWithCode(response.raw().code(), response.message())
            }
        }
    }

}