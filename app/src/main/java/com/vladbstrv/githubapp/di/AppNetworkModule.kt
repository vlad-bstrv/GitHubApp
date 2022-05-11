package com.vladbstrv.githubapp.di

import com.vladbstrv.githubapp.data.retrofit.GithubApi
import com.vladbstrv.githubapp.data.retrofit.RetrofitUsersRepoImpl
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppNetworkModule {

    @Singleton
    @Provides
    fun provideGithubApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUsersRepo(api: GithubApi): UsersRepo {
        return RetrofitUsersRepoImpl(api)
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Named("api_url")
    fun provideBaseUrl(): String {
        return "https://api.github.com"
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("api_url") baseUrl: String, factory: Converter.Factory ): Retrofit {
        return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(factory)
        .build()
    }

}

//viewModel { UserListViewModel(get()) }
//viewModel { UserDetailsViewModel(get()) }