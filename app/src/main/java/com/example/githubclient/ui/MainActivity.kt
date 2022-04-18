package com.example.githubclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubclient.R
import com.example.githubclient.ui.list_screen.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, ListFragment())
            .commitNow()

    }
}
