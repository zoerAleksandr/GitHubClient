package com.example.githubclient.data.retrofit

import com.example.githubclient.domain.*
import io.reactivex.rxjava3.core.Single

class RetrofitUserProfileRepositoryImpl : UserProfileRepository {
    private val retrofitApi = RetrofitUserProfileApiImpl()

    override fun getAll(): MutableList<UserProfileEntity> {
        TODO("Not yet implemented")
    }

    override fun getProfile(login: String): Single<UserProfileEntity> {
        return retrofitApi.userProfileApi.getUser(login)
    }

    override fun delete(userProfile: UserProfileEntity): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(userProfile: UserProfileEntity) {
        TODO("Not yet implemented")
    }
}