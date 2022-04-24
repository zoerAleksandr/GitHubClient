package com.example.githubclient.ui.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclient.domain.usecase.UseCaseRepoList
import com.example.githubclient.ui.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class DetailViewModel(
    private val useCaseRepoList: UseCaseRepoList,
    private val liveData: MutableLiveData<AppState> = MutableLiveData()
) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    fun getReposList(listOwner: String): LiveData<AppState> {
        liveData.postValue(AppState.Loading(true))
        compositeDisposable.add(
            useCaseRepoList.getReposList(listOwner).subscribeBy(
                onError = { liveData.postValue(AppState.Error(it)) },
                onSuccess = { liveData.postValue(AppState.Success(it)) }
            )
        )
        return liveData
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}