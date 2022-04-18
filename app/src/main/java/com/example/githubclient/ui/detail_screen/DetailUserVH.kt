package com.example.githubclient.ui.detail_screen

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.databinding.ItemRepositoryBinding
import com.example.githubclient.domain.UserRepo

class DetailUserVH(private val binding: ItemRepositoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: UserRepo){
            Log.d("Debug_ViewHolder", "$repo")
            binding.repoNameTextView.text = repo.repoName
            binding.repoDescriptionTextView.text = repo.repoDesc
        }
}