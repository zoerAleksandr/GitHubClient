package com.example.githubclient.data.mock

import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MockUserProfileRepositoryImpl(
) : UserProfileRepository {
    private val listUser: MutableList<UserProfileEntity> = mutableListOf(
        UserProfileEntity(
            1,
            "name1",
            "https://avatars.githubusercontent.com/u/79718551?v=4",
            "listOf()"
        ),
        UserProfileEntity(
            2,
            "name2",
            "https://avatars.githubusercontent.com/u/79718551?v=4",
            "listOf()"
        ),
        UserProfileEntity(
            3,
            "name3",
            "https://avatars.githubusercontent.com/u/79718551?v=4",
            "listOf()"
        ),
    )

    override fun getProfile(login: String): Single<UserProfileEntity> {
        return listUser.find { it.login == login }?.let {
            Single.just(it).subscribeOn(Schedulers.io())
        } ?: Single.error(Throwable("Не нашел"))
    }
}