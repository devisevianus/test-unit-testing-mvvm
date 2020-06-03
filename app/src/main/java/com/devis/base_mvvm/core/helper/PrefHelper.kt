package com.devis.base_mvvm.core.helper

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */
 
class PrefHelper @Inject constructor(private val context: Context) {

    private fun pref(): SharedPreferences {
        return context.getSharedPreferences("ProjectName", Context.MODE_PRIVATE)
    }

}