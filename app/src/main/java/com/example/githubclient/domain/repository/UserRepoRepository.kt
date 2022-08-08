package com.example.githubclient.domain.repository

import com.example.githubclient.domain.entity.UserRepoEntity

interface UserRepoRepository {
    suspend fun getReposList(loginOwner: String): List<UserRepoEntity>
    suspend fun getRepo(id: Long): UserRepoEntity?
}