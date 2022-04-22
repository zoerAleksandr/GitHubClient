package com.example.githubclient.ui.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.domain.userrepo.UserRepoRepository

class DetailViewModelFactory(private val repository: UserRepoRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }
}