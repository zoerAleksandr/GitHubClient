package com.example.githubclient

import android.app.Application
import com.example.githubclient.di.modulesData
import com.example.githubclient.di.modulesUseCase
import com.example.githubclient.di.modulesUtil
import com.example.githubclient.di.modulesVM
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    modulesVM,
                    modulesUseCase,
                    modulesData,
                    modulesUtil
                )
            )
        }
    }
}