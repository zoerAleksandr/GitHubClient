package com.example.githubclient.ui.list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclient.domain.UserProfileRepository
import com.example.githubclient.ui.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class ListViewModel(
    private val userProfileRepository: UserProfileRepository,
    private val liveData: MutableLiveData<AppState> = MutableLiveData()
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    fun getData(): LiveData<AppState> = liveData

    fun onSend(request: String) {
        liveData.postValue(AppState.Loading(true))
        compositeDisposable.add(
            userProfileRepository.getProfile(request)
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