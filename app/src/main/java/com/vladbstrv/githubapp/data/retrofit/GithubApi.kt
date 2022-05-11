package com.vladbstrv.githubapp.data.retrofit

import com.vladbstrv.githubapp.data.retrofit.dto.ReposDto
import com.vladbstrv.githubapp.data.retrofit.dto.UserDetailDto
import com.vladbstrv.githubapp.data.retrofit.dto.UserListDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<ReposDto>>

    @GET("users/{user}")
    fun userDetail(@Path("user") user: String): Single<UserDetailDto>

    @GET("users?q=repos:%3E42+followers:%3E1000")
    fun listUsers(): Single<List<UserListDto>>
}