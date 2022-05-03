package com.example.githubclient.ui.list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile

class ListViewModelFactory(private val useCaseGetUserProfile: UseCaseGetUserProfile): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel (useCaseGetUserProfile) as T
    }
}