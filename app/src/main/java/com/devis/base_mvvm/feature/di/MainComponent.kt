package com.devis.base_mvvm.feature.di

import com.devis.base_mvvm.core.di.CoreModule
import com.devis.base_mvvm.data.di.DataModule
import com.devis.base_mvvm.feature.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by devis on 03/06/20
 */
 
@Singleton
@Component(
    modules = [
        MainModule::class,
        MainViewModelModule::class,
        CoreModule::class,
        DataModule::class
    ]
)
interface MainComponent {
    fun inject(activity: MainActivity)
}