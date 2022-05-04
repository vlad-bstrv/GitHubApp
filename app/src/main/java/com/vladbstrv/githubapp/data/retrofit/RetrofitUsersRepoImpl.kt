package com.vladbstrv.githubapp.data.retrofit

import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserDetailEntity
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUsersRepoImpl : UsersRepo {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: GithubApi = retrofit.create(GithubApi::class.java)

    override fun observeUsersList(): Single<List<UserListEntity>> {
        return api.listUsers()
    }

    override fun observeUsersDetails(username: String): Single<UserDetailEntity> {
        return api.userDetail(username)
    }

    override fun observeRepos(username: String): Single<List<ReposEntity>> {
        return api.listRepos(username)
    }
}