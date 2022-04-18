package com.example.githubclient.ui.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclient.domain.UserRepoRepository
import com.example.githubclient.ui.AppState

class DetailViewModel(
    private val userRepoRepository: UserRepoRepository,
    private val liveData: MutableLiveData<AppState> = MutableLiveData()
) :
    ViewModel() {
    fun getReposList(listOwner: String): LiveData<AppState> {
        liveData.postValue(AppState.Loading(true))
        liveData.postValue(
            AppState.Success(
                userRepoRepository.getReposList(listOwner)
            )
        )
        return liveData
    }
}