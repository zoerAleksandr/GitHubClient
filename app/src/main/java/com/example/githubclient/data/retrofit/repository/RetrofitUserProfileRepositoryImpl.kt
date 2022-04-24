package com.example.githubclient.data.retrofit.repository

import com.example.githubclient.data.retrofit.RetrofitApiImpl
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitUserProfileRepositoryImpl(private val retrofitApi: RetrofitApiImpl) :
    UserProfileRepository {
    override fun getProfile(login: String): Single<UserProfileEntity> {
        return retrofitApi.retrofitApi.getUser(login)
            .subscribeOn(Schedulers.io())
            .map { dto ->
                UserProfileEntity(id = dto.id, login = dto.login, image = dto.image, repos = dto.repos)
            }
    }
}