package com.example.githubclient

import android.app.Application
import android.content.Context
import com.example.githubclient.data.mock.MockUserRepoRepository
import com.example.githubclient.data.retrofit.RetrofitApiImpl
import com.example.githubclient.data.retrofit.userprofile.RetrofitUserProfileRepositoryImpl
import com.example.githubclient.data.retrofit.userrepo.RetrofitUserRepoRepositoryImpl
import com.example.githubclient.domain.userprofile.UserProfileRepository
import com.example.githubclient.domain.userrepo.UserRepoRepository

class App : Application() {
    private val retrofit: RetrofitApiImpl = RetrofitApiImpl()
    val userProfileRepository: UserProfileRepository by lazy { RetrofitUserProfileRepositoryImpl(retrofit) }
    val userReposRepository: UserRepoRepository by lazy { RetrofitUserRepoRepositoryImpl(retrofit) }
}

val Context.app: App
    get() = applicationContext as App