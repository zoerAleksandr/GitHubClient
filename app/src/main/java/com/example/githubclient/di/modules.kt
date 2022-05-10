package com.example.githubclient.di

import com.example.githubclient.ViewModelStore
import com.example.githubclient.data.retrofit.RetrofitApi
import com.example.githubclient.data.retrofit.repository.RetrofitUserProfileRepositoryImpl
import com.example.githubclient.data.retrofit.repository.RetrofitUserRepoRepositoryImpl
import com.example.githubclient.domain.repository.UserProfileRepository
import com.example.githubclient.domain.repository.UserRepoRepository
import com.example.githubclient.domain.usecase.UseCaseGetRepoList
import com.example.githubclient.domain.usecase.UseCaseGetUserProfile
import com.example.githubclient.ui.detail_screen.DetailViewModelFactory
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ViewModelFactoryModule{
    @Provides
    fun provideViewModelFactory(useCaseGetRepoList: UseCaseGetRepoList): DetailViewModelFactory {
        return DetailViewModelFactory(useCaseGetRepoList)
    }
}

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserProfileRepository(retrofitApi: RetrofitApi): UserProfileRepository {
        return RetrofitUserProfileRepositoryImpl(retrofitApi)
    }

    @Singleton
    @Provides
    fun provideUserRepoRepository(retrofitApi: RetrofitApi): UserRepoRepository {
        return RetrofitUserRepoRepositoryImpl(retrofitApi)
    }
}

@Module
class UseCaseModule {

    @Provides
    fun provideUseCaseGetUserProfile(repository: UserProfileRepository): UseCaseGetUserProfile {
        return UseCaseGetUserProfile(repository)
    }

    @Provides
    fun provideUseCaseGetRepoList(repository: UserRepoRepository): UseCaseGetRepoList {
        return UseCaseGetRepoList(repository)
    }
}

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideViewModelStore(): ViewModelStore {
        return ViewModelStore()
    }
}

@Module
class RetrofitModule {

    @Provides
    @Named("baseUrl")
    fun providesBaseUrl(): String {
        return "https://api.github.com/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @Named("baseUrl") baseUrl: String,
        callAdapterFactory: CallAdapter.Factory,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RetrofitApi {
        return retrofit.create(RetrofitApi::class.java)
    }

    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory {
        return RxJava3CallAdapterFactory.create()
    }

    @Provides
    fun provideConvertorFactory(): Converter.Factory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .create()
        )
    }
}