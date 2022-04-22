package com.example.githubclient.ui.list_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import coil.transform.CircleCropTransformation
import com.example.githubclient.R
import com.example.githubclient.app
import com.example.githubclient.databinding.FragmentListBinding
import com.example.githubclient.domain.userprofile.UserProfileEntity
import com.example.githubclient.ui.AppState
import com.example.githubclient.ui.detail_screen.DetailUserProfileFragment

const val USER_KEY = "USER_KEY"

class ListFragment : Fragment(R.layout.fragment_list) {
    private val binding: FragmentListBinding by viewBinding()
    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(requireContext().app.userProfileRepository)
    }
    private var userProfileForBundle: UserProfileEntity? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner) { renderData(it) }

        binding.sendButton.setOnClickListener {
            viewModel.onSend(binding.loginEditText.text.toString())
        }

        binding.userProfileCardView.setOnClickListener {
            val bundle = Bundle().also { it.putParcelable(USER_KEY, userProfileForBundle) }
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, DetailUserProfileFragment.newInstance(bundle))
                .addToBackStack("")
                .commit()
        }
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Loading -> {
                binding.apply {
                    loadingLayout.visibility = View.VISIBLE
                    binding.userProfileCardView.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                    binding.firstVisitTextView.visibility = View.GONE
                }
            }
            is AppState.Success<*> -> {
                val userProfile = state.data as UserProfileEntity
                binding.apply {
                    errorTextView.visibility = View.GONE
                    loadingLayout.visibility = View.GONE
                    firstVisitTextView.visibility = View.GONE
                    userProfileCardView.visibility = View.VISIBLE
                    userProfileForBundle = userProfile
                    userNameTextView.text = userProfile.login
                    avatarImageView.load(userProfile.image) {
                        placeholder(R.drawable.ic_placeholder_account_circle_24)
                        transformations(CircleCropTransformation())
                    }
                }
            }
            is AppState.Error -> {
                binding.apply {
                    loadingLayout.visibility = View.GONE
                    userProfileCardView.visibility = View.GONE
                    firstVisitTextView.visibility = View.GONE
                    errorTextView.visibility = View.VISIBLE
                    errorTextView.text = state.error.message
                }
            }
        }
    }
}