package com.devis.base_mvvm.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Created by devis on 03/06/20
 */

abstract class BaseFragment : Fragment() {

    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutInflater = activity?.layoutInflater
        mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE)
        return layoutInflater?.inflate(layoutRes(), null)
    }

    @LayoutRes
    abstract fun layoutRes(): Int

}