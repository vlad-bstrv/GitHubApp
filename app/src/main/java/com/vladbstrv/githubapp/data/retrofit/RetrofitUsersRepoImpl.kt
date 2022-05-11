package com.vladbstrv.githubapp.data.retrofit

import com.vladbstrv.githubapp.data.retrofit.utils.Mapper
import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserDetailEntity
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import io.reactivex.rxjava3.core.Single

class RetrofitUsersRepoImpl(
    private val api: GithubApi
) : UsersRepo {

    override fun observeUsersList(): Single<List<UserListEntity>> {
        return api.listUsers().map { Mapper().mapUserListDtoToEntity(it) }
    }

    override fun observeUsersDetails(username: String): Single<UserDetailEntity> {
        return api.userDetail(username).map {
            Mapper().mapUserDetailDtoToEntity(it)
        }
    }

    override fun observeRepos(username: String): Single<List<ReposEntity>> {
        return api.listRepos(username).map {
            Mapper().mapReposDtoToEntity(it)
        }
    }
}
