package com.example.githubclient.data.room

import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository
import io.reactivex.rxjava3.core.Single

class RoomUserProfileRepositoryImpl : UserProfileRepository {
    override fun getProfile(login: String): Single<UserProfileEntity> {
        TODO("Not yet implemented")
    }
}