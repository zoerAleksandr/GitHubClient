package com.example.githubclient.ui.list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.domain.UserProfileRepository

class ListViewModelFactory(private val userProfileRepository: UserProfileRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel (userProfileRepository) as T
    }
}