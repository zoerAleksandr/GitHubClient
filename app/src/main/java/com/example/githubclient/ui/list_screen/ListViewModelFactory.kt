package com.example.githubclient.ui.list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.domain.Repository

class ListViewModelFactory(private val repository: Repository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel (repository) as T
    }
}