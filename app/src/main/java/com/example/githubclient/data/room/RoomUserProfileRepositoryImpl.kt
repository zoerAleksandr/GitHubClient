package com.example.githubclient.data.room

import com.example.githubclient.domain.userprofile.UserProfileEntity
import com.example.githubclient.domain.userprofile.UserProfileRepository
import io.reactivex.rxjava3.core.Single

class RoomUserProfileRepositoryImpl : UserProfileRepository {
    override fun getAll(): MutableList<UserProfileEntity> {
        TODO("Not yet implemented")
    }

    override fun getProfile(login: String): Single<UserProfileEntity> {
        TODO("Not yet implemented")
    }

    override fun delete(userProfile: UserProfileEntity): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(userProfile: UserProfileEntity) {
        TODO("Not yet implemented")
    }
}