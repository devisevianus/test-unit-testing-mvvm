package com.devis.base_mvvm.data.utils

/**
 * Created by devis on 03/06/20
 */

sealed class ResultState<out T : Any?> {
    data class Success<out T : Any?>(
        val data: T?,
        val isLast: Boolean = false) : ResultState<T>()
    data class Error(val errorMessage: String?) : ResultState<Nothing>()
    data class ErrorWithCode(
        val code: Int, val errorMessage: String?) : ResultState<Nothing>()
}