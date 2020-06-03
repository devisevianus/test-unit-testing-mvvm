package com.devis.base_mvvm.feature.di

import com.devis.base_mvvm.data.repository.MainRepository
import com.devis.base_mvvm.data.source.remote.RemoteMainDataSource
import dagger.Module
import dagger.Provides

/**
 * Created by devis on 03/06/20
 */
 
@Module
class MainModule {
    @Provides
    fun provideMainRepository(remoteMainDataSource: RemoteMainDataSource): MainRepository {
        return MainRepository.MainRepositoryImpl(remoteMainDataSource)
    }
}