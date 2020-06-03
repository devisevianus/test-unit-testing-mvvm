package com.devis.base_mvvm.core.di

import android.content.Context
import androidx.room.Room
import com.devis.base_mvvm.core.helper.PrefHelper
import com.devis.base_mvvm.core.utils.AppDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * Created by devis on 03/06/20
 */

@Module
class CoreModule(private val context: Context) {

    @Provides
    fun providesContext(): Context {
        return context
    }

    @Provides
    fun providesAppDispatcher(): AppDispatchers = AppDispatchers(Dispatchers.Main, Dispatchers.IO)

    @Provides
    fun providesPrefHelper(): PrefHelper {
        return PrefHelper(context)
    }

    /*@Provides
    @Singleton
    fun provideAppDatabase(application: Context): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, AppDatabase.DATABASE_NAME
        ).build()
    }*/

}