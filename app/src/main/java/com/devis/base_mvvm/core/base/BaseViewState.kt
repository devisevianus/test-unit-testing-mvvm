package com.devis.base_mvvm.core.base

/**
 * Created by devis on 03/06/20
 */

sealed class BaseViewState<out R> {
    object Loading : BaseViewState<Nothing>()
    data class Error(val errorMessage: String?) : BaseViewState<Nothing>()
    data class Success<T>(
        val data: T?,
        val isLast: Boolean? = false
    ) : BaseViewState<T>()
}