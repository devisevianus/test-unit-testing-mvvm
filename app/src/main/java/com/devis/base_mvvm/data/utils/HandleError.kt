package com.devis.base_mvvm.data.utils

import com.devis.base_mvvm.core.model.ErrorMdl
import com.google.gson.Gson
import retrofit2.Response
import java.util.*

/**
 * Created by devis on 03/06/20
 */

fun Throwable.handleError(): ErrorMdl {
    var message: String? = this.message
    if (message != null) {
        if (message.toLowerCase(Locale.getDefault()).contains("unable")) {
            message = "Please check your connection"
            return ErrorMdl(message = message, status = false)
        } else if (message.toLowerCase(Locale.getDefault()).contains("connection abort")) {
            message = "Please check your connection"
        }
    }

    return ErrorMdl(message = message, status = false)
}

fun Response<*>.handleError(): ErrorMdl {
    val message: String? = this.message()
    var errorParser = ErrorMdl(message = message, status = false)
    val body = this.errorBody()
    if (body != null) {
        val gson = Gson()
        val adapter = gson.getAdapter<ErrorMdl>(ErrorMdl::class.java)

        errorParser = adapter.fromJson(body.string())
    }


    return errorParser
}