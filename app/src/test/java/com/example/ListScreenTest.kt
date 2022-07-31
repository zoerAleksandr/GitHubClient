package com.example

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile
import com.example.githubclient.ui.list_screen.ListViewModel
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ListScreenTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCaseGetUserProfile: UseCaseGetUserProfile

    private val schedulers = ScheduleProviderStub()

    private lateinit var viewModel: ListViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = ListViewModel(useCaseGetUserProfile, schedulers)
    }

    @Test
    fun useCase_getProfile_test() {
        val userProfileEntity = UserProfileEntity(null, null, null, null)
        val request = "Login"

        `when`(useCaseGetUserProfile.getProfile(request)).thenReturn(
            Single.just(userProfileEntity)
        )

        viewModel.onSend(request)

        verify(useCaseGetUserProfile, times(1)).getProfile(request)
    }
}