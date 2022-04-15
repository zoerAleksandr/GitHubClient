package com.example.githubclient.data

import com.example.githubclient.domain.Repository
import com.example.githubclient.domain.UserProfile

class MockRepositoryImpl : Repository {
    private val listUser: MutableList<UserProfile> = mutableListOf(
        UserProfile(1, "name1", "url"),
        UserProfile(2, "name2", "url"),
        UserProfile(3, "name3", "url"),
        UserProfile(4, "name4", "url"),
    )

    override fun getAll(): MutableList<UserProfile> = listUser

    override fun getProfile(id: Long): UserProfile? {
        return listUser.find { targetId -> id.equals(targetId) }
    }

    override fun delete(userProfile: UserProfile): Boolean {
        return listUser.remove(userProfile)
    }

    override fun update(userProfile: UserProfile){
        val index = listUser.indexOf(userProfile)
        listUser[index] = userProfile
    }
}