package com.example.githubclient.data.retrofit

import com.example.githubclient.data.retrofit.entity.UserProfileDTO
import com.example.githubclient.data.retrofit.entity.UserRepoDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {
    @GET("users/{user}/repos")
    fun listReposAsync(@Path("user") user: String?): Deferred<List<UserRepoDTO>>

    @GET("users/{user}")
    fun getUserAsync(@Path("user") user: String?): Deferred<UserProfileDTO>
}