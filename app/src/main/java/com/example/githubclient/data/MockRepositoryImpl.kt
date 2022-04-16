package com.example.githubclient.data

import com.example.githubclient.domain.Repository
import com.example.githubclient.domain.UserProfile

class MockRepositoryImpl : Repository {
    private val listUser: MutableList<UserProfile> = mutableListOf(
        UserProfile(1, "name1", "https://avatars.githubusercontent.com/u/79718551?v=4", mutableListOf()),
        UserProfile(2, "name2", "https://avatars.githubusercontent.com/u/79718551?v=4", mutableListOf()),
        UserProfile(3, "name3", "https://avatars.githubusercontent.com/u/79718551?v=4", mutableListOf()),
        UserProfile(4, "name4", "https://avatars.githubusercontent.com/u/79718551?v=4", mutableListOf()),
    )

    override fun getAll(): MutableList<UserProfile> = listUser

    override fun getProfile(login: String): UserProfile? {
        return listUser[0]
    }

    override fun delete(userProfile: UserProfile): Boolean {
        return listUser.remove(userProfile)
    }

    override fun update(userProfile: UserProfile){
        val index = listUser.indexOf(userProfile)
        listUser[index] = userProfile
    }
}