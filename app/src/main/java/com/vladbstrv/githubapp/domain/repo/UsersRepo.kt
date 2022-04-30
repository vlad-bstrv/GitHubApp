package com.vladbstrv.githubapp.domain.repo

import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserDetailEntity
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import io.reactivex.rxjava3.core.Single

interface UsersRepo {

    fun observeUsersList(): Single<List<UserListEntity>>

    fun observeUsersDetails(username: String): Single<UserDetailEntity>

    fun observeRepos(username: String): Single<List<ReposEntity>>
}