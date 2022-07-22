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
                UserListEntity("Vlad-bstrv1"),
                UserListEntity("Vlad-bstrv2"),
                UserListEntity("Vlad-bstrv3"),
                UserListEntity("Vlad-bstrv4"),
                UserListEntity("Vlad-bstrv5"),
                UserListEntity("Vlad-bstrv6"),
                UserListEntity("Vlad-bstrv7"),
                UserListEntity("Vlad-bstrv8"),
                UserListEntity("Vlad-bstrv9"),
                UserListEntity("Vlad-bstrv10"),
                UserListEntity("Vlad-bstrv11"),
                UserListEntity("Vlad-bstrv12"),
                UserListEntity("Vlad-bstrv13"),
                UserListEntity("Vlad-bstrv14"),
                UserListEntity("Vlad-bstrv15"),
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
                ReposEntity(7, "repo7"),
                ReposEntity(8, "repo8"),
                ReposEntity(9, "repo9"),
                ReposEntity(10, "repo10"),
                ReposEntity(11, "repo11"),
                ReposEntity(12, "repo12"),
                ReposEntity(13, "repo13"),
                ReposEntity(14, "repo14"),
            )
        )
    }
}