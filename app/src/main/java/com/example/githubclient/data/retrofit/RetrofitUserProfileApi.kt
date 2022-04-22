package com.example.githubclient.data.retrofit

import com.example.githubclient.domain.UserProfileEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitUserProfileApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Single<List<UserProfileEntity>>

    @GET("users/{user}")
    fun getUser(@Path("user") user: String?): Single<UserProfileEntity>
}