package com.devis.base_mvvm.feature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.devis.base_mvvm.core.base.BaseViewState
import com.devis.base_mvvm.core.model.UserMdl
import com.devis.base_mvvm.core.utils.AppDispatchers
import com.devis.base_mvvm.data.repository.MainRepository
import com.devis.base_mvvm.data.utils.ResultState
import com.devis.base_mvvm.feature.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by devis on 03/06/20
 */

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var result: Observer<BaseViewState<UserMdl>>

    @Mock
    lateinit var repo: MainRepository

    private lateinit var mainViewModel: MainViewModel

    private val appDispatchers = AppDispatchers(Dispatchers.IO, Dispatchers.Main)
    private val username = "devisevianus"

    private val userResponse = UserMdl(
        "",
        0,
        "",
        ""
    )

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(appDispatchers.main)
        mainViewModel = MainViewModel(repo, appDispatchers)
        mainViewModel.mainResult.observeForever(result)
    }

    @Test
    fun `should success get user`() = runBlocking {
        `when`(repo.getUserData(username)).thenReturn(
            ResultState.Success(userResponse)
        )

        mainViewModel.getUserData(username)

        verify(result).onChanged(BaseViewState.Success(userResponse))
        clearInvocations(repo, result)


        //verify(result).onChanged(BaseViewState.Success(userResponse))
    }

}