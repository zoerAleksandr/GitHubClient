package com.example.githubclient

import android.app.Application
import android.content.Context
import com.example.githubclient.data.MockRepositoryImpl
import com.example.githubclient.domain.Repository

class App : Application() {
    val repository: Repository by lazy { MockRepositoryImpl() }
}

val Context.app: App
    get() = applicationContext as App