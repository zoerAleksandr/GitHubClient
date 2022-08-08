package com.example.githubclient.ui.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubclient.domain.usecase.UseCaseGetRepoList
import com.example.githubclient.ui.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCaseGetRepoList: UseCaseGetRepoList) :
    ViewModel() {
    private val liveData: MutableLiveData<AppState> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun getData(): LiveData<AppState> = liveData

    fun getReposList(listOwner: String) {
        liveData.postValue(AppState.Loading(true))
        viewModelScope.launch {
            val userRepo = useCaseGetRepoList.getReposList(listOwner)
            liveData.postValue(AppState.Success(userRepo))
        }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}