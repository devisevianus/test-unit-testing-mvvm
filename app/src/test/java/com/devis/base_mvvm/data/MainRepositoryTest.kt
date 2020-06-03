package com.devis.base_mvvm.data

import com.devis.base_mvvm.core.model.UserMdl
import com.devis.base_mvvm.data.repository.MainRepository
import com.devis.base_mvvm.data.source.remote.RemoteMainDataSource
import com.devis.base_mvvm.data.utils.ResultState
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Created by devis on 03/06/20
 */

class MainRepositoryTest {

    private var remoteMainDataSource = mock(RemoteMainDataSource::class.java)
    private lateinit var repo: MainRepository

    private val username = "devisevianus"

    private val userResponse = UserMdl(
        "",
        0,
        "",
        ""
    )

    @Before
    fun setup() {
        repo = MainRepository.MainRepositoryImpl(remoteMainDataSource)
    }

    @Test
    fun `should success get user`() {
        val expected = ResultState.Success(userResponse)
        val result = runBlocking {
            `when`(remoteMainDataSource.getUserData(username)).thenReturn(
                ResultState.Success(userResponse)
            )

            repo.getUserData(username)
        }

        assertEquals(expected, result)
    }

    @Test
    fun `should error get user`() {
        val expected = ResultState.Error("")
        val result = runBlocking {
            `when`(remoteMainDataSource.getUserData(username)).thenReturn(
                ResultState.Error("")
            )

            repo.getUserData(username)
        }

        //assertEquals(expected, result)
        assert(expected.javaClass === result.javaClass)
    }

}