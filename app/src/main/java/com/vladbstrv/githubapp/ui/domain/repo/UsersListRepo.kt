package com.vladbstrv.githubapp.ui.domain.repo

import com.vladbstrv.githubapp.ui.domain.entity.UserListEntity
import io.reactivex.rxjava3.core.Single

interface UsersListRepo {

    fun observeUsersList(): Single<List<UserListEntity>>
}