package com.devis.base_mvvm.feature.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devis.base_mvvm.core.base.BaseViewModelFactory
import com.devis.base_mvvm.core.base.ViewModelKey
import com.devis.base_mvvm.feature.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by devis on 03/06/20
 */
 
@Module
abstract class MainViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}