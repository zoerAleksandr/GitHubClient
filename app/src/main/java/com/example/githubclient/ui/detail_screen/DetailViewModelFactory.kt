package com.example.githubclient.ui.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.domain.usecase.UseCaseGetRepoList

class DetailViewModelFactory(private val useCaseGetRepoList: UseCaseGetRepoList) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(useCaseGetRepoList) as T
    }
}