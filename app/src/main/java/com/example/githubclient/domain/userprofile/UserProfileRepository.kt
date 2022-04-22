package com.example.githubclient.domain.userprofile

import io.reactivex.rxjava3.core.Single

interface UserProfileRepository {
    fun getAll(): MutableList<UserProfileEntity>
    fun getProfile(login: String): Single<UserProfileEntity>
    fun delete(userProfile: UserProfileEntity): Boolean
    fun update(userProfile: UserProfileEntity)
}