package com.example.githubclient.domain

interface UserRepoRepository {
    fun getReposList(loginOwner: String): List<UserRepo>
    fun getRepo(id: Long): UserRepo?
}