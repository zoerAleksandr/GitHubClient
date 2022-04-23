package com.example.githubclient.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserProfile(
    val id: Long,
    val name: String,
    val image: String,
    val repos: List<UserRepo>
): Parcelable
