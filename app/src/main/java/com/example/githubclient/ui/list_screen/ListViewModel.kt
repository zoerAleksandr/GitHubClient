package com.example.githubclient.ui.list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile
import com.example.githubclient.ui.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class ListViewModel(private val useCaseGetUserProfile: UseCaseGetUserProfile) : ViewModel() {
    private val liveData: MutableLiveData<AppState> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun getData(): LiveData<AppState> = liveData

    fun onSend(request: String) {
        liveData.postValue(AppState.Loading(true))
        compositeDisposable.add(
            useCaseGetUserProfile.getProfile(request)
                .subscribeBy(
                    onSuccess = { userProfile ->
                        liveData.postValue(AppState.Success(userProfile))
                    },
                    onError = { liveData.postValue(AppState.Error(it)) }
                )
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}