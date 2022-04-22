package com.example.githubclient.domain.userrepo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepoEntity(
    val id: Long?,
    val loginOwner: String?,
    val repoName: String?,
    val repoDesc: String?
) : Parcelable
