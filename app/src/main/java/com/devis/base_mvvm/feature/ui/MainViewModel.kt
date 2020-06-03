package com.devis.base_mvvm.feature.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devis.base_mvvm.core.base.BaseViewModel
import com.devis.base_mvvm.core.base.BaseViewState
import com.devis.base_mvvm.core.model.UserMdl
import com.devis.base_mvvm.core.utils.AppDispatchers
import com.devis.base_mvvm.data.repository.MainRepository
import com.devis.base_mvvm.data.utils.ResultState
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */
 
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private val _mMainResult = MutableLiveData<BaseViewState<UserMdl>>()
    val mainResult: LiveData<BaseViewState<UserMdl>> = _mMainResult

    fun getUserData(username: String) {
        viewModelScope.launch {
            val request = withContext(dispatchers.io) {
                repository.getUserData(username)
            }
            when (request) {
                is ResultState.Success -> {
                    _mMainResult.value = BaseViewState.Success(request.data)
                }
                is ResultState.Error -> {
                    _mMainResult.value = BaseViewState.Error(request.errorMessage)
                }
            }
        }
    }

}