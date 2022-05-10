package com.example.githubclient

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

class ViewModelStore {
    private val store: MutableMap<Int, ViewModel> = WeakHashMap()

    fun saveViewModel(viewModel: ViewModel) {
        store[viewModel.hashCode()] = viewModel
        Log.d("Debug", "saveViewModel - $store")
    }

    fun getViewModel(key: Int): ViewModel? {
        Log.d("Debug", "getViewModel - $store")
        return store[key]
    }
}