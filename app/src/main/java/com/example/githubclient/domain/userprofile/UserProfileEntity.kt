package com.example.githubclient.domain.userprofile

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserProfileEntity(
    @SerializedName("id") val id: Long?,
    @SerializedName("login") val login: String?,
    @SerializedName("avatar_url") val image: String?,
    @SerializedName("repos_url") val repos: String?
) : Parcelable