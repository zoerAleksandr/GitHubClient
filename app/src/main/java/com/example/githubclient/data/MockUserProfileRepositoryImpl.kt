package com.example.githubclient.data

import com.example.githubclient.domain.UserProfile
import com.example.githubclient.domain.UserProfileRepository
import com.example.githubclient.domain.UserRepoRepository

class MockUserProfileRepositoryImpl(
    private val reposUser: UserRepoRepository
) : UserProfileRepository {
    private val listUser: MutableList<UserProfile> = mutableListOf(
        UserProfile(1, "name1", "https://avatars.githubusercontent.com/u/79718551?v=4", listOf()),
        UserProfile(2, "name2", "https://avatars.githubusercontent.com/u/79718551?v=4", listOf()),
        UserProfile(3, "name3", "https://avatars.githubusercontent.com/u/79718551?v=4", listOf()),
        UserProfile(4, "name4", "https://avatars.githubusercontent.com/u/79718551?v=4", listOf()),
    )

    override fun getAll(): MutableList<UserProfile> = listUser

    override fun getProfile(login: String): UserProfile? {
        return listUser.find { it.name == login }
    }

    override fun delete(userProfile: UserProfile): Boolean {
        return listUser.remove(userProfile)
    }

    override fun update(userProfile: UserProfile) {
        val index = listUser.indexOf(userProfile)
        listUser[index] = userProfile
    }
}