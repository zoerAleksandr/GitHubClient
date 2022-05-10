package com.example.githubclient.ui

import com.example.githubclient.domain.entity.UserProfileEntity

interface OpenFragmentContract {
    fun openFragment(userProfileEntity: UserProfileEntity)
}