package com.example.githubclient.domain.repository

import com.example.githubclient.domain.entity.UserProfileEntity

interface UserProfileRepository {
    suspend fun getProfile(login: String): UserProfileEntity?
}