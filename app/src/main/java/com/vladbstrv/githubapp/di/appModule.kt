package com.vladbstrv.githubapp.di

import com.vladbstrv.githubapp.data.MockUsersRepoImpl
import com.vladbstrv.githubapp.data.retrofit.GithubApi
import com.vladbstrv.githubapp.data.retrofit.RetrofitUsersRepoImpl
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import com.vladbstrv.githubapp.ui.userdetails.UserDetailsViewModel
import com.vladbstrv.githubapp.ui.userlist.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
//    single<UsersRepo> { RetrofitUsersRepoImpl(get()) }
    single<UsersRepo> { MockUsersRepoImpl() }
    single<GithubApi> { get<Retrofit>().create(GithubApi::class.java) }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named("api_url")))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(get())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }
    single(named("api_url")) { "https://api.github.com" }

    viewModel { UserListViewModel(get()) }
    viewModel { UserDetailsViewModel(get()) }
}


