package com.example.githubclient.ui.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.domain.repository.UserRepoRepository
import com.example.githubclient.domain.usecase.UseCaseRepoList

class DetailViewModelFactory(private val useCaseRepoList: UseCaseRepoList): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(useCaseRepoList) as T
    }
}