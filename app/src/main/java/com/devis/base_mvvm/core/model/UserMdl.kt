package com.devis.base_mvvm.core.model

import java.io.Serializable

/**
 * Created by devis on 03/06/20
 */

data class UserMdl(
    val login: String,
    val id: Long,
    val name: String,
    val location: String
) : Serializable