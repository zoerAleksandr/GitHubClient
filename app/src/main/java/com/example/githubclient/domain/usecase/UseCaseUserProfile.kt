package com.example.githubclient.domain.usecase

import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class UseCaseUserProfile(private val repository: UserProfileRepository) {
    fun getProfile(login: String): Single<UserProfileEntity> {
        return repository.getProfile(login).subscribeOn(Schedulers.io())
    }
}