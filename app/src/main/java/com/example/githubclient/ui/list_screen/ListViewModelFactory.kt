package com.example.githubclient.ui.list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.domain.repository.UserProfileRepository
import com.example.githubclient.domain.usecase.UseCaseUserProfile

class ListViewModelFactory(private val useCaseUserProfile: UseCaseUserProfile): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel (useCaseUserProfile) as T
    }
}