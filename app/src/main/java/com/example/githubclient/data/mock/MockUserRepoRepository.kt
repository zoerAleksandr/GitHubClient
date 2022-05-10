package com.example.githubclient.data.mock

import com.example.githubclient.domain.entity.UserRepoEntity
import com.example.githubclient.domain.repository.UserRepoRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MockUserRepoRepository : UserRepoRepository {
    private val reposList: List<UserRepoEntity> = listOf(
        UserRepoEntity(0L, "nameRepo1", "desc1", "Kotlin"),
        UserRepoEntity(1L, "nameRepo2", "desc2", "Java"),
        UserRepoEntity(2L, "nameRepo3", "desc3", "Java"),
        UserRepoEntity(3L, "nameRepo4", "desc4", "Kotlin"),
    )

    override fun getReposList(loginOwner: String): Single<List<UserRepoEntity>> {
        return if (reposList.isNullOrEmpty()) {
            Single.error(Throwable("У пользователя нет репозиториев"))
        } else {
            Single.just(reposList).subscribeOn(Schedulers.io())
        }
    }

    override fun getRepo(id: Long): UserRepoEntity? {
        return reposList.find { it.id == id }
    }
}