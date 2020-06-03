package com.devis.base_mvvm.data.di

import com.devis.base_mvvm.core.helper.PrefHelper
import com.devis.base_mvvm.data.source.LoginDataSource
import com.devis.base_mvvm.data.source.remote.ApiClient
import com.devis.base_mvvm.data.source.remote.AuthService
import com.devis.base_mvvm.data.source.remote.RemoteLoginDataSource
import com.devis.base_mvvm.data.utils.AuthInterceptor
import com.devis.base_mvvm.data.utils.TokenAuthenticator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by devis on 03/06/20
 */
 
@Module
class DataModule {
    // Service
    @Provides
    fun provideServiceAuth(): AuthService {
        return ApiClient.retrofitClient("Base URL").create(AuthService::class.java)
    }

    // Authenticator
    @Provides
    @Singleton
    fun provideTokenAuthenticator(
        prefHelper: PrefHelper,
        authService: AuthService
    ): TokenAuthenticator {
        return TokenAuthenticator(prefHelper, authService)
    }

    // Interceptor
    @Provides
    @Singleton
    fun provideAuthInterceptor(prefHelper: PrefHelper): AuthInterceptor {
        return AuthInterceptor(prefHelper)
    }

    // Remote Data Source
    @Provides
    fun provideRemoteLoginDataSource(
        apiAuthService: AuthService,
        prefHelper: PrefHelper): LoginDataSource {
        return RemoteLoginDataSource(apiAuthService, prefHelper)
    }
}