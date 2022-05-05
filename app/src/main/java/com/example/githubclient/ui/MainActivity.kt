package com.example.githubclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.githubclient.R
import com.example.githubclient.databinding.ActivityMainBinding
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.ui.detail_screen.DetailUserProfileFragment
import com.example.githubclient.ui.list_screen.ListFragment

class MainActivity : AppCompatActivity(), OpenFragmentContract {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(R.id.main_container) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, ListFragment())
                .commitNow()
        }
    }

    override fun openFragment(userProfileEntity: UserProfileEntity) {
        supportFragmentManager.beginTransaction()
            .replace(binding.root.id, DetailUserProfileFragment.newInstance(userProfileEntity))
            .addToBackStack(null)
            .commit()
    }
}
