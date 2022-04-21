package com.example.githubclient.data.mock

import com.example.githubclient.domain.UserRepo
import com.example.githubclient.domain.UserRepoRepository
import io.reactivex.rxjava3.core.Single

class MockUserRepoRepository : UserRepoRepository {
    private val reposList: List<UserRepo> = listOf(
        UserRepo(0L, "name1", "repoName1owner1", "desc1"),
        UserRepo(1L, "name1", "repoName2owner1", "desc2"),
        UserRepo(2L, "name1", "repoName3owner1", "desc3"),
        UserRepo(3L, "name1", "repoName4owner1", "desc4"),

        UserRepo(4L, "name2", "repoName1owner2", "desc1"),
        UserRepo(5L, "name2", "repoName2owner2", "desc2"),
        UserRepo(6L, "name2", "repoName3owner2", "desc3"),
        UserRepo(7L, "name2", "repoName4owner2", "desc4"),
    )

    override fun getReposList(loginOwner: String): Single<List<UserRepo>> {
        return if (reposList.none { it.loginOwner == loginOwner }) {
            Single.error(Throwable("У пользователя нет репозиториев"))
        } else {
            Single.just(reposList.filter { it.loginOwner == loginOwner })
        }
    }

    override fun getRepo(id: Long): UserRepo? {
        return reposList.find { it.id == id }
    }
}