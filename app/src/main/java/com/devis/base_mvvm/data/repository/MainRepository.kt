package com.devis.base_mvvm.data.repository

import com.devis.base_mvvm.core.model.UserMdl
import com.devis.base_mvvm.data.source.remote.RemoteMainDataSource
import com.devis.base_mvvm.data.utils.ResultState
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */
 
interface MainRepository {
    suspend fun getUserData(username: String): ResultState<UserMdl>

    class MainRepositoryImpl @Inject constructor(
        private val remoteMainDataSource: RemoteMainDataSource
    ) : MainRepository {
        override suspend fun getUserData(username: String): ResultState<UserMdl> {
            return remoteMainDataSource.getUserData(username)
        }
    }
}