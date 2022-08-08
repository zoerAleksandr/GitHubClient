package com.example.githubclient.data.room.reposotiry

import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository

class RoomUserProfileRepositoryImpl : UserProfileRepository {
    override suspend fun getProfile(login: String): UserProfileEntity {
        TODO("Not yet implemented")
    }
}