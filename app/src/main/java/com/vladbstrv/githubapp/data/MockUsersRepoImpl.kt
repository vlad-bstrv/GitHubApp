package com.vladbstrv.githubapp.data

import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserDetailEntity
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import io.reactivex.rxjava3.core.Single

class MockUsersRepoImpl : UsersRepo {
    override fun observeUsersList(): Single<List<UserListEntity>> {
        return Single.just(
            listOf(
                UserListEntity("Vlad-bstrv"),
                UserListEntity("Vlad-bstrv"),
            )
        )
    }

    override fun observeUsersDetails(username: String): Single<UserDetailEntity> {
        return Single.just(
            UserDetailEntity(
                1,
                "https://avatars.githubusercontent.com/u/61514687?v=4",
                "vlad-bstrv",
                "Vladislav Bystrov"
            )
        )
    }

    override fun observeRepos(username: String): Single<List<ReposEntity>> {
        return Single.just(
            listOf(
                ReposEntity(1, "repo1"),
                ReposEntity(2, "repo2"),
                ReposEntity(3, "repo3"),
                ReposEntity(4, "repo4"),
                ReposEntity(5, "repo5"),
                ReposEntity(6, "repo6"),
            )
        )
    }
}