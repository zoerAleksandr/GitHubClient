package com.example.githubclient.data.retrofit

import com.example.githubclient.data.retrofit.userprofile.UserProfileDTO
import com.example.githubclient.data.retrofit.userrepo.UserRepoDTO
import com.example.githubclient.domain.userrepo.UserRepoEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Single<List<UserRepoDTO>>

    @GET("users/{user}")
    fun getUser(@Path("user") user: String?): Single<UserProfileDTO>
}