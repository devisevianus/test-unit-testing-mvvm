package com.devis.base_mvvm.feature.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.devis.base_mvvm.R
import com.devis.base_mvvm.core.base.BaseActivity
import com.devis.base_mvvm.core.base.BaseViewState
import com.devis.base_mvvm.core.di.CoreModule
import com.devis.base_mvvm.feature.di.DaggerMainComponent
import com.devis.base_mvvm.feature.di.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDI()
        initObserve()

        mViewModel.getUserData("devisevianus")
    }

    private fun injectDI() {
        DaggerMainComponent.builder().mainModule(MainModule())
            .coreModule(CoreModule(applicationContext))
            .build().inject(this)
    }

    private fun initObserve() {
        mViewModel.apply {
            mainResult.observe(this@MainActivity, Observer {
                when (it) {
                    is BaseViewState.Success -> {
                        tv_name.text = it.data?.name
                    }
                    is BaseViewState.Error -> {
                        Log.e("getUserData", it.errorMessage.toString())
                    }
                }
            })
        }
    }

}
