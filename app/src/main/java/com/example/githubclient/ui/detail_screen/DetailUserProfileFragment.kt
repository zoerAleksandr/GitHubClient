package com.example.githubclient.ui.detail_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import coil.transform.CircleCropTransformation
import com.example.githubclient.R
import com.example.githubclient.app
import com.example.githubclient.databinding.FragmentDetailUserProfileBinding
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.entity.UserRepoEntity
import com.example.githubclient.ui.AppState
import javax.inject.Inject

const val USER_KEY = "USER_KEY"

class DetailUserProfileFragment : Fragment(R.layout.fragment_detail_user_profile) {

    companion object {
        fun newInstance(userProfileEntity: UserProfileEntity) = DetailUserProfileFragment().apply {
            arguments = Bundle()
            arguments?.putParcelable(USER_KEY, userProfileEntity)
        }
    }

    private val binding: FragmentDetailUserProfileBinding by viewBinding()
    private val listAdapter: DetailUserAdapter by lazy { DetailUserAdapter() }

    @Inject
    lateinit var viewModelFactory: DetailViewModelFactory
    private lateinit var viewModel: DetailViewModel

    override fun onAttach(context: Context) {
        app.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        binding.listRepoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.listRepoRecyclerView.adapter = listAdapter

        arguments?.getParcelable<UserProfileEntity>(USER_KEY)?.let { userProfile ->
            binding.avatarImageView.load(userProfile.image) {
                transformations(CircleCropTransformation())
            }
            binding.userNameTextView.text = userProfile.login
            userProfile.login?.let {
                viewModel.getReposList(it)
            }
        }
        viewModel.getData().observe(viewLifecycleOwner) { appState ->
            renderData(appState)
        }
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
                binding.errorTextView.visibility = View.GONE
            }
            is AppState.Success<*> -> {
                val reposList = appState.data as List<UserRepoEntity>
                binding.loadingLayout.visibility = View.GONE
                binding.listRepoRecyclerView.visibility = View.VISIBLE
                listAdapter.setReposList(reposList)
            }
            is AppState.Error -> {
                binding.errorTextView.visibility = View.VISIBLE
                binding.errorTextView.text = appState.error.message.toString()
                binding.loadingLayout.visibility = View.GONE
            }
        }
    }
}