package com.example

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile
import com.example.githubclient.ui.AppState
import com.example.githubclient.ui.list_screen.ListViewModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ListScreenTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var testCoroutineRule = TestCoroutinesRule()

    @Mock
    private lateinit var useCaseGetUserProfile: UseCaseGetUserProfile

    private lateinit var viewModel: ListViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = ListViewModel(useCaseGetUserProfile)
    }

    @Test
    fun useCase_getProfile_test() {
        testCoroutineRule.runBlockingTest {
            val userProfileEntity = UserProfileEntity(null, null, null, null)
            val request = "Login"

            `when`(useCaseGetUserProfile.getProfile(request)).thenReturn(userProfileEntity)
            viewModel.onSend(request)
            verify(useCaseGetUserProfile, times(1)).getProfile(request)
        }
    }

    @Test
    fun liveData_returnResult_test() {
        testCoroutineRule.runBlockingTest {
            val observer = Observer<AppState> {}
            val liveData = viewModel.getData()

            val request = "Login"
            val userProfileEntity = UserProfileEntity(1L, null, null, null)
            val answer = AppState.Success(userProfileEntity)

            `when`(useCaseGetUserProfile.getProfile(request)).thenReturn(userProfileEntity)

            try {
                liveData.observeForever(observer)
                viewModel.onSend(request)
                assertEquals(answer, liveData.value)
            } finally {
                liveData.removeObserver(observer)
            }
        }
    }
}