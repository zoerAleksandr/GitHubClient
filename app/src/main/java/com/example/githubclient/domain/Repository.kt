package com.example.githubclient.domain

interface Repository {
    fun getAll(): MutableList<UserProfile>
    fun getProfile(id: Long): UserProfile?
    fun delete(userProfile: UserProfile): Boolean
    fun update(userProfile: UserProfile)
}