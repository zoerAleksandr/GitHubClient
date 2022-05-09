package com.example.githubclient

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.githubclient.di.AppComponent
import com.example.githubclient.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app