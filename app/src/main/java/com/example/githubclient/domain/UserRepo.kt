package com.example.githubclient.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepo(
    val id: Long,
    val loginOwner: String,
    val repoName: String,
    val repoDesc: String
) : Parcelable
