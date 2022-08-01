package com.example.githubclient.data.mock

import com.example.githubclient.domain.entity.UserRepoEntity
import com.example.githubclient.domain.repository.UserRepoRepository

class MockUserRepoRepository : UserRepoRepository {
    private val reposList: List<UserRepoEntity> = listOf(
        UserRepoEntity(0L, "nameRepo1", "desc1", "Kotlin"),
        UserRepoEntity(1L, "nameRepo2", "desc2", "Java"),
        UserRepoEntity(2L, "nameRepo3", "desc3", "Java"),
        UserRepoEntity(3L, "nameRepo4", "desc4", "Kotlin"),
        UserRepoEntity(4L, "nameRepo5", "desc5", "Kotlin"),
        UserRepoEntity(5L, "nameRepo6", "desc6", "Kotlin"),
        UserRepoEntity(6L, "nameRepo7", "desc7", "Kotlin"),
        UserRepoEntity(7L, "nameRepo8", "desc8", "Kotlin"),
        UserRepoEntity(8L, "nameRepo9", "desc9", "Kotlin"),
    )

    override suspend fun getReposList(loginOwner: String): List<UserRepoEntity> {
        return reposList
    }

    override suspend fun getRepo(id: Long): UserRepoEntity? {
        return reposList.find { it.id == id }
    }
}