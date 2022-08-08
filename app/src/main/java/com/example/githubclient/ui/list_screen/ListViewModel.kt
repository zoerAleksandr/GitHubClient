package com.example.githubclient.ui.list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile
import com.example.githubclient.ui.AppState
import kotlinx.coroutines.launch

class ListViewModel(
    private val useCaseGetUserProfile: UseCaseGetUserProfile,
) : ViewModel() {
    private val liveData: MutableLiveData<AppState> = MutableLiveData()

    fun getData(): LiveData<AppState> = liveData

    fun onSend(request: String) {
        liveData.postValue(AppState.Loading(true))

        viewModelScope.launch {
            val userProfileEntity = useCaseGetUserProfile.getProfile(request)
            liveData.postValue(AppState.Success(userProfileEntity))
        }
    }
}