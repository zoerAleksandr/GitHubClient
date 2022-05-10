package com.example.githubclient.domain.repository

import com.example.githubclient.domain.entity.UserProfileEntity
import io.reactivex.rxjava3.core.Single

interface UserProfileRepository {
    fun getProfile(login: String): Single<UserProfileEntity>
}