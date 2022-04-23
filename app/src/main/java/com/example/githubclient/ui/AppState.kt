package com.example.githubclient.ui

sealed class AppState {
    data class Success<T>(val data: T) : AppState()
    data class Loading(val progress: Boolean) : AppState()
    data class Error(val error: Throwable) : AppState()
}
