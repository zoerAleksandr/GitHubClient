package com.example.githubclient.data.retrofit.repository

import com.example.githubclient.data.retrofit.RetrofitApi
import com.example.githubclient.data.retrofit.entity.UserRepoDTO
import com.example.githubclient.domain.entity.UserRepoEntity
import com.example.githubclient.domain.repository.UserRepoRepository

class RetrofitUserRepoRepositoryImpl(private val retrofitApi: RetrofitApi) :
    UserRepoRepository {
    override suspend fun getReposList(loginOwner: String): List<UserRepoEntity> {
        val dto = retrofitApi.listReposAsync(loginOwner).await()
        return listEntityFromListDto(dto)

    }

    override suspend fun getRepo(id: Long): UserRepoEntity? {
        TODO("Not yet implemented")
    }

    private fun listEntityFromListDto(dto: List<UserRepoDTO>): List<UserRepoEntity> {
        return dto.map {
            UserRepoEntity(
                id = it.id,
                name = it.name,
                description = it.description,
                language = it.language
            )
        }
    }
}