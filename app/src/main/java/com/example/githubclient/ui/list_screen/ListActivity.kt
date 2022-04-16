package com.example.githubclient.ui.list_screen

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import coil.transform.CircleCropTransformation
import com.example.githubclient.R
import com.example.githubclient.app
import com.example.githubclient.databinding.ActivityListBinding
import com.example.githubclient.domain.UserProfile
import com.example.githubclient.ui.AppState

class ListActivity : AppCompatActivity() {
    private val binding: ActivityListBinding by viewBinding()
    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(app.repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        viewModel.getData().observe(this) { renderData(it) }

        binding.sendButton.setOnClickListener {
            binding.emptyTextView.visibility = View.GONE
            viewModel.onSend(binding.loginEditText.text.toString())
        }
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
                binding.userProfileCardView.visibility = View.GONE
                binding.errorTextView.visibility = View.GONE
            }
            is AppState.Success<*> -> {
                binding.loadingLayout.visibility = View.GONE
                binding.userProfileCardView.visibility = View.VISIBLE
                (state.data as UserProfile?)?.let { userProfile ->
                    binding.avatarImageView.load(userProfile.image){
                        transformations(CircleCropTransformation())
                    }
                    binding.userNameTextView.text = userProfile.name
                }
            }
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE
                binding.userProfileCardView.visibility = View.GONE
                binding.errorTextView.text = state.error.message
            }
        }
    }
}
