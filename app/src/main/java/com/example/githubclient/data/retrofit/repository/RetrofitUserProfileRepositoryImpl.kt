package com.example.githubclient.data.retrofit.repository

import com.example.githubclient.data.retrofit.RetrofitApi
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository

class RetrofitUserProfileRepositoryImpl(private val retrofitApi: RetrofitApi) :
    UserProfileRepository {
    override suspend fun getProfile(login: String): UserProfileEntity {
        val dto = retrofitApi.getUserAsync(login).await()
        return UserProfileEntity(
            id = dto.id,
            login = dto.login,
            image = dto.image,
            repos = dto.repos
        )
    }
}