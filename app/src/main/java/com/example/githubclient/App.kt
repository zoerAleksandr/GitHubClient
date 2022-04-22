package com.example.githubclient

import android.app.Application
import android.content.Context
import com.example.githubclient.data.mock.MockUserProfileRepositoryImpl
import com.example.githubclient.data.mock.MockUserRepoRepository
import com.example.githubclient.data.retrofit.RetrofitUserProfileRepositoryImpl
import com.example.githubclient.domain.UserProfileRepository
import com.example.githubclient.domain.UserRepoRepository

class App : Application() {
    val userProfileRepository: UserProfileRepository by lazy { RetrofitUserProfileRepositoryImpl() }
    val userReposRepository: UserRepoRepository by lazy { MockUserRepoRepository() }
}

val Context.app: App
    get() = applicationContext as App