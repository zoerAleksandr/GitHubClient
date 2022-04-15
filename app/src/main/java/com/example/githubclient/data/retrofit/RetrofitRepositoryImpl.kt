package com.example.githubclient.data.retrofit

import com.example.githubclient.domain.Repository
import com.example.githubclient.domain.UserProfile

class RetrofitRepositoryImpl : Repository {
    override fun getAll(): MutableList<UserProfile> {
        TODO("Not yet implemented")
    }

    override fun getProfile(id: Long): UserProfile {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(userProfile: UserProfile): Boolean {
        TODO("Not yet implemented")
    }
}