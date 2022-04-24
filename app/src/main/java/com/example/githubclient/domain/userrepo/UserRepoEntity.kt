package com.example.githubclient.domain.userrepo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepoEntity(
    val id: Long?,
    val name: String?,
    val description: String?,
    val language: String?
) : Parcelable