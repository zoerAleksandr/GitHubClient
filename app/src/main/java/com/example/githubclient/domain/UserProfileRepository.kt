package com.example.githubclient.domain

import io.reactivex.rxjava3.core.Single

interface UserProfileRepository {
    fun getAll(): MutableList<UserProfile>
    fun getProfile(login: String): Single<UserProfile>
    fun delete(userProfile: UserProfile): Boolean
    fun update(userProfile: UserProfile)
}