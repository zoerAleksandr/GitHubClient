package com.example.githubclient.data.retrofit.userprofile

import com.google.gson.annotations.SerializedName

data class UserProfileDTO(
    @SerializedName("id") val id: Long?,
    @SerializedName("login") val login: String?,
    @SerializedName("avatar_url") val image: String?,
    @SerializedName("repos_url") val repos: String?
)