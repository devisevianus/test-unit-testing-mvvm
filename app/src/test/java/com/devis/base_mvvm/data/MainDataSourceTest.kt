package com.devis.base_mvvm.data

import com.devis.base_mvvm.core.model.UserMdl
import com.devis.base_mvvm.data.source.MainDataSource
import com.devis.base_mvvm.data.source.remote.RemoteMainDataSource
import com.devis.base_mvvm.data.source.remote.UserService
import com.devis.base_mvvm.data.utils.ResultState
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response

/**
 * Created by devis on 03/06/20
 */
 
class MainDataSourceTest {
    private lateinit var mainDataSource: MainDataSource
    private var mApiService = mock(UserService::class.java)

    private val userResponse = UserMdl(
        "",
        0,
        "",
        ""
    )

    private lateinit var result: ResultState<UserMdl>

    private val username = "devisevianus"

    @Before
    fun setup() {
        mainDataSource = RemoteMainDataSource(mApiService)
    }

    @Test
    fun `should success get user`() {
        val response = ResultState.Success(userResponse)
        runBlocking {
            `when`(mApiService.getUserData(username)).thenReturn(Response.success(userResponse))

            val repo = mainDataSource.getUserData(username)

            assertEquals(response, repo)
        }
    }

    @Test
    fun `should error get user`() {
        val expected = Response.error<ResponseBody>(400, ResponseBody.create(MediaType.parse("application/json"), ""))
        runBlocking {
            `when`(mApiService.getUserData(username)).thenReturn(Response.error(401, ResponseBody.create(
                MediaType.parse("application/json"), ""))
            )

            val repo = mainDataSource.getUserData(username)

            if (repo is ResultState.ErrorWithCode) {
                assertEquals(repo.errorMessage, expected.message())
            }
        }
    }
}