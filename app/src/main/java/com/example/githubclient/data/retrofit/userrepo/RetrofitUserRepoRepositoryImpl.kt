package com.example.githubclient.data.retrofit.userrepo

import com.example.githubclient.data.retrofit.RetrofitApiImpl
import com.example.githubclient.domain.userrepo.UserRepoEntity
import com.example.githubclient.domain.userrepo.UserRepoRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitUserRepoRepositoryImpl(private val retrofit: RetrofitApiImpl) : UserRepoRepository {
    override fun getReposList(loginOwner: String): Single<List<UserRepoEntity>> {
        return retrofit.retrofitApi.listRepos(loginOwner)
            .subscribeOn(Schedulers.io())
            .map {
                listEntityFromListDto(it)
            }
    }

    override fun getRepo(id: Long): UserRepoEntity? {
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