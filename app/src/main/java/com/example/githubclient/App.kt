package com.example.githubclient

import android.app.Application
import com.example.githubclient.data.MockRepositoryImpl
import com.example.githubclient.domain.Repository

class App : Application() {
    val repository: Repository by lazy { MockRepositoryImpl() }
}