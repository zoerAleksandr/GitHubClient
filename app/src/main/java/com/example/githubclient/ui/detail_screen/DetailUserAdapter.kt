package com.example.githubclient.ui.detail_screen

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.databinding.ItemRepositoryBinding
import com.example.githubclient.domain.entity.UserRepoEntity

class DetailUserAdapter : RecyclerView.Adapter<DetailUserVH>() {
    private var reposList: List<UserRepoEntity> = listOf()

    fun setReposList(list: List<UserRepoEntity>) {
        Log.d("Debug_Adapter", "$list")
        reposList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailUserVH {
        val binding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DetailUserVH(binding)
    }

    override fun onBindViewHolder(holder: DetailUserVH, position: Int) {
        holder.bind(reposList[position])
    }

    override fun getItemCount(): Int = reposList.size
}