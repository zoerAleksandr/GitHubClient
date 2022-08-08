package com.example.githubclient.domain.usecase

import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository

class UseCaseGetUserProfile(private val repository: UserProfileRepository) {
    suspend fun getProfile(login: String): UserProfileEntity? {
        return repository.getProfile(login)
    }
}