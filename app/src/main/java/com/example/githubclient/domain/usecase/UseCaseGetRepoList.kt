package com.example.githubclient.domain.usecase

import com.example.githubclient.domain.entity.UserRepoEntity
import com.example.githubclient.domain.repository.UserRepoRepository
import io.reactivex.rxjava3.core.Single

class UseCaseGetRepoList(private val repository: UserRepoRepository) {
    fun getReposList(loginOwner: String): Single<List<UserRepoEntity>>{
        return repository.getReposList(loginOwner)
    }
}