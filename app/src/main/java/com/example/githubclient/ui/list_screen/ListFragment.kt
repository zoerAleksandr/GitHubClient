package com.example.githubclient.ui.list_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import coil.transform.CircleCropTransformation
import com.example.githubclient.R
import com.example.githubclient.ViewModelStore
import com.example.githubclient.databinding.FragmentListBinding
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile
import com.example.githubclient.ui.AppState
import com.example.githubclient.ui.OpenFragmentContract
import org.koin.android.ext.android.inject

const val VIEW_MODEL_STORAGE_KEY = "VIEW_MODEL_STORAGE_KEY"

class ListFragment : Fragment(R.layout.fragment_list) {
    private val binding: FragmentListBinding by viewBinding()
    private lateinit var viewModel: ListViewModel
    private val viewModelStore: ViewModelStore by inject()
    private var userProfileForBundle: UserProfileEntity? = null
    private val openFragmentContract by lazy { activity as OpenFragmentContract }

    override fun onAttach(context: Context) {
        if (activity !is OpenFragmentContract) {
            throw IllegalStateException("This Activity not extend OpenFragmentContract")
        }
        super.onAttach(context)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(VIEW_MODEL_STORAGE_KEY, viewModel.hashCode())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            createListViewModel()
        } else {
            viewModel =
                viewModelStore.getViewModel(
                    savedInstanceState.getInt(VIEW_MODEL_STORAGE_KEY)
                ) as ListViewModel?
                    ?: createListViewModel()
        }

        viewModel.getData().observe(viewLifecycleOwner) { renderData(it) }

        binding.sendButton.setOnClickListener {
            viewModel.onSend(binding.loginEditText.text.toString())
        }

        binding.userProfileCardView.setOnClickListener {
            userProfileForBundle?.let {
                openFragmentContract.openFragment(it)
            }
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

    private fun createListViewModel(): ListViewModel {
        val useCase: UseCaseGetUserProfile by inject()
        viewModel = ListViewModelFactory(useCase).create(ListViewModel::class.java)
        viewModelStore.saveViewModel(viewModel)
        return viewModel
    }
}