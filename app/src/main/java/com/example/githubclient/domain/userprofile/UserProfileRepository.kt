package com.example.githubclient.domain.userprofile

import io.reactivex.rxjava3.core.Single

interface UserProfileRepository {
    fun getProfile(login: String): Single<UserProfileEntity>
}