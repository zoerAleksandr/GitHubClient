package com.example.githubclient.ui.list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclient.domain.Repository
import com.example.githubclient.ui.AppState

class ListViewModel(
    private val repository: Repository,
    private val liveData: MutableLiveData<AppState> = MutableLiveData()
) : ViewModel() {
    fun getData(): LiveData<AppState> = liveData

    fun onSend(request: String) {
        liveData.postValue(AppState.Loading(true))
        liveData.postValue(
            AppState.Success(
                repository.getProfile(request)
            )
        )
    }
}