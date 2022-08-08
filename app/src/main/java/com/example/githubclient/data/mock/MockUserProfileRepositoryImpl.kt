package com.example.githubclient.data.mock

import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.repository.UserProfileRepository

class MockUserProfileRepositoryImpl : UserProfileRepository {
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

    override suspend fun getProfile(login: String): UserProfileEntity? {
        return listUser.find { it.login == login }
    }
}