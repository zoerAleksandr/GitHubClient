package com.example.githubclient.domain.userrepo

import io.reactivex.rxjava3.core.Single

interface UserRepoRepository {
    fun getReposList(loginOwner: String): Single<List<UserRepoEntity>>
    fun getRepo(id: Long): UserRepoEntity?
}