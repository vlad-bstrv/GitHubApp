package com.vladbstrv.githubapp.data.retrofit

import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserDetailEntity
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<ReposEntity>>

    @GET("users/{user}")
    fun userDetail(@Path("user") user: String): Single<UserDetailEntity>

    @GET("users?q=repos:%3E42+followers:%3E1000")
    fun listUsers(): Single<List<UserListEntity>>
}