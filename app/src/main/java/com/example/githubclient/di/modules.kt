package com.example.githubclient.di

import com.example.githubclient.ViewModelStore
import com.example.githubclient.data.mock.MockUserProfileRepositoryImpl
import com.example.githubclient.data.mock.MockUserRepoRepository
import com.example.githubclient.data.retrofit.RetrofitApi
import com.example.githubclient.data.retrofit.repository.RetrofitUserProfileRepositoryImpl
import com.example.githubclient.data.retrofit.repository.RetrofitUserRepoRepositoryImpl
import com.example.githubclient.domain.repository.UserProfileRepository
import com.example.githubclient.domain.repository.UserRepoRepository
import com.example.githubclient.domain.usecase.UseCaseGetRepoList
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile
import com.example.githubclient.ui.detail_screen.DetailViewModel
import com.example.githubclient.ui.list_screen.ListViewModel
import com.example.githubclient.ui.list_screen.ListViewModelFactory
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val modulesVM = module {
    viewModel { ListViewModel(useCaseGetUserProfile = get()) }
    viewModel { DetailViewModel(useCaseGetRepoList = get()) }
}

val modulesUseCase = module {
    single { UseCaseGetUserProfile(repository = get()) }
    single { UseCaseGetRepoList(repository = get()) }
}

val modulesData = module {
    single(named("base_usr")) { "https://api.github.com/" }

    single<UserRepoRepository> { MockUserRepoRepository() }
    single<UserProfileRepository> { MockUserProfileRepositoryImpl() }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named("base_usr")))
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .build()
    }
    single { get<Retrofit>().create(RetrofitApi::class.java) }
    factory<Converter.Factory> {
        GsonConverterFactory
            .create(
                GsonBuilder()
                    .setLenient()
                    .create()
            )
    }
    factory<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }
}

val modulesUtil = module {
    single { ViewModelStore() }
}