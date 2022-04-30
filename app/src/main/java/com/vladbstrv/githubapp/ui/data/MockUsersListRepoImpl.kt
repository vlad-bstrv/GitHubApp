package com.vladbstrv.githubapp.ui.data

import com.vladbstrv.githubapp.ui.domain.entity.UserListEntity
import com.vladbstrv.githubapp.ui.domain.repo.UsersListRepo
import io.reactivex.rxjava3.core.Single

class MockUsersListRepoImpl: UsersListRepo {
    override fun observeUsersList(): Single<List<UserListEntity>> {
        return Single.just(listOf(
            UserListEntity("1"),
            UserListEntity("2"),
            UserListEntity("13"),
            UserListEntity("4"),
            UserListEntity("5"),
            UserListEntity("6"),
            UserListEntity("7"),
            UserListEntity("8"),
            UserListEntity("9"),
            UserListEntity("10"),
            UserListEntity("11"),
            UserListEntity("12"),
            UserListEntity("1"),
            UserListEntity("2"),
            UserListEntity("13"),
            UserListEntity("4"),
            UserListEntity("5"),
            UserListEntity("6"),
            UserListEntity("7"),
            UserListEntity("8"),
            UserListEntity("9"),
            UserListEntity("10"),
            UserListEntity("11"),
            UserListEntity("12"),
        ))
    }
}