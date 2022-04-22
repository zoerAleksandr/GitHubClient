package com.example.githubclient.ui.detail_screen

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.databinding.ItemRepositoryBinding
import com.example.githubclient.domain.userrepo.UserRepoEntity

class DetailUserVH(private val binding: ItemRepositoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(repoEntity: UserRepoEntity){
            Log.d("Debug_ViewHolder", "$repoEntity")
            binding.repoNameTextView.text = repoEntity.repoName
            binding.repoDescriptionTextView.text = repoEntity.repoDesc
        }
}