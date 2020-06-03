package com.devis.base_mvvm.core.model

import com.google.gson.annotations.SerializedName

/**
 * Created by devis on 03/06/20
 */

data class BaseMdl<T>(
    var status: Boolean,
    var http_code: Int? = null,
    var message: String? = "",
    var data: T? = null,
    var meta: MetaMdl? = null
)

class EmptyMdl(
    @SerializedName("success")
    val success: Boolean? = null,
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("locale")
    val locale: String? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("meta")
    val meta: MetaMdl? = null
)

class ErrorMdl(
    val status: Boolean = false,
    val http_code: Int? = null,
    val message: String? = null
)

data class MetaMdl(
    @SerializedName("pagination")
    val pagination: PaginationMdl? = null
)

class PaginationMdl(
    @SerializedName("current_page")
    val currentPage: Int? = null,
    @SerializedName("from")
    val from: Int? = null,
    @SerializedName("last_page")
    val lastPage: Int? = null,
    @SerializedName("path")
    val path: String? = null,
    @SerializedName("per_page")
    val perPage: Int? = null,
    @SerializedName("to")
    val to: Int? = null,
    @SerializedName("total")
    val total: Int? = null
)