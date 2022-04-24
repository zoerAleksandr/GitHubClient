package com.example.githubclient

import android.app.Application
import android.content.Context
import com.example.githubclient.data.retrofit.RetrofitApiImpl
import com.example.githubclient.data.retrofit.repository.RetrofitUserProfileRepositoryImpl
import com.example.githubclient.data.retrofit.repository.RetrofitUserRepoRepositoryImpl
import com.example.githubclient.domain.repository.UserProfileRepository
import com.example.githubclient.domain.repository.UserRepoRepository
import com.example.githubclient.domain.usecase.UseCaseRepoList
import com.example.githubclient.domain.usecase.UseCaseUserProfile

class App : Application() {
    private val retrofit: RetrofitApiImpl = RetrofitApiImpl()
    val useCaseUserProfile: UseCaseUserProfile by lazy { UseCaseUserProfile(userRepository) }
    val useCaseRepoList: UseCaseRepoList by lazy { UseCaseRepoList(repoRepository) }
    private val userRepository: UserProfileRepository by lazy { RetrofitUserProfileRepositoryImpl(retrofit) }
    private val repoRepository: UserRepoRepository by lazy { RetrofitUserRepoRepositoryImpl(retrofit) }
}

val Context.app: App
    get() = applicationContext as App