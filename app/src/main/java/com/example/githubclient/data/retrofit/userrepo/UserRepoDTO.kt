package com.example.githubclient.data.retrofit.userrepo

import com.google.gson.annotations.SerializedName

data class UserRepoDTO(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("language") val language: String?
)