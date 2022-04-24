package com.example.githubclient.domain.userprofile

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserProfileEntity(
    val id: Long?,
    val login: String?,
    val image: String?,
    val repos: String?
) : Parcelable