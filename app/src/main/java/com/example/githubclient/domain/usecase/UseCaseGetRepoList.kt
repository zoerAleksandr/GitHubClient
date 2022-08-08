package com.example.githubclient.domain.usecase

import com.example.githubclient.domain.entity.UserRepoEntity
import com.example.githubclient.domain.repository.UserRepoRepository

class UseCaseGetRepoList(private val repository: UserRepoRepository) {
    suspend fun getReposList(loginOwner: String): List<UserRepoEntity> {
        return repository.getReposList(loginOwner)
    }
}