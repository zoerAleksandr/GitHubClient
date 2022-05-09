package com.example.githubclient.di

import com.example.githubclient.ui.list_screen.ListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        UseCaseModule::class,
        UtilsModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent {
    fun inject(listFragment: ListFragment)
}