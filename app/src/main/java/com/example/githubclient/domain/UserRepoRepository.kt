package com.example.githubclient.domain

import io.reactivex.rxjava3.core.Single

interface UserRepoRepository {
    fun getReposList(loginOwner: String): Single<List<UserRepo>>
    fun getRepo(id: Long): UserRepo?
}