package com.example.githubclient.data.retrofit.userprofile

import com.example.githubclient.data.retrofit.RetrofitApiImpl
import com.example.githubclient.domain.userprofile.UserProfileEntity
import com.example.githubclient.domain.userprofile.UserProfileRepository
import io.reactivex.rxjava3.core.Single

class RetrofitUserProfileRepositoryImpl(private val retrofitApi: RetrofitApiImpl) : UserProfileRepository {

    override fun getAll(): MutableList<UserProfileEntity> {
        TODO("Not yet implemented")
    }

    override fun getProfile(login: String): Single<UserProfileEntity> {
        return retrofitApi.retrofitApi.getUser(login)
    }

    override fun delete(userProfile: UserProfileEntity): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(userProfile: UserProfileEntity) {
        TODO("Not yet implemented")
    }
}