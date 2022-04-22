package com.example.githubclient.data.mock

import com.example.githubclient.domain.userrepo.UserRepoEntity
import com.example.githubclient.domain.userrepo.UserRepoRepository
import io.reactivex.rxjava3.core.Single

class MockUserRepoRepository : UserRepoRepository {
    private val reposList: List<UserRepoEntity> = listOf(
        UserRepoEntity(0L, "name1", "repoName1owner1", "desc1"),
        UserRepoEntity(1L, "name1", "repoName2owner1", "desc2"),
        UserRepoEntity(2L, "name1", "repoName3owner1", "desc3"),
        UserRepoEntity(3L, "name1", "repoName4owner1", "desc4"),

        UserRepoEntity(4L, "name2", "repoName1owner2", "desc1"),
        UserRepoEntity(5L, "name2", "repoName2owner2", "desc2"),
        UserRepoEntity(6L, "name2", "repoName3owner2", "desc3"),
        UserRepoEntity(7L, "name2", "repoName4owner2", "desc4"),
    )

    override fun getReposList(loginOwner: String): Single<List<UserRepoEntity>> {
        return if (reposList.none { it.loginOwner == loginOwner }) {
            Single.error(Throwable("У пользователя нет репозиториев"))
        } else {
            Single.just(reposList.filter { it.loginOwner == loginOwner })
        }
    }

    override fun getRepo(id: Long): UserRepoEntity? {
        return reposList.find { it.id == id }
    }
}