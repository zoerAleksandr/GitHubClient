package com.example.githubclient.ui.detail_screen

import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.databinding.ItemRepositoryBinding
import com.example.githubclient.domain.entity.UserRepoEntity

class DetailUserVH(private val binding: ItemRepositoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(repoEntity: UserRepoEntity) {
        binding.repoNameTextView.text = repoEntity.name
        binding.repoDescriptionTextView.text = repoEntity.description
        binding.repoLanguageTextView.text = "${repoEntity.language}"
    }
}