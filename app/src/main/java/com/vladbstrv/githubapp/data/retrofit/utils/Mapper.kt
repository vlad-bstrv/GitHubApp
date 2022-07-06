package com.vladbstrv.githubapp.data.retrofit.utils

import com.vladbstrv.githubapp.data.retrofit.dto.ReposDto
import com.vladbstrv.githubapp.data.retrofit.dto.UserDetailDto
import com.vladbstrv.githubapp.data.retrofit.dto.UserListDto
import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserDetailEntity
import com.vladbstrv.githubapp.domain.entity.UserListEntity

class Mapper {

    fun mapUserDetailDtoToEntity(userDetailDto: UserDetailDto): UserDetailEntity {
        return UserDetailEntity(
            id = userDetailDto.id,
            avatarUrl = userDetailDto.avatarUrl,
            login = userDetailDto.login,
            name = userDetailDto.name
        )
    }

    fun mapUserListDtoToEntity(userListDto: List<UserListDto>): List<UserListEntity> {
        val list: MutableList<UserListEntity> = mutableListOf()

        for (user in userListDto) {
            list.add(UserListEntity(login = user.login))
        }

        return list
    }

    fun mapReposDtoToEntity(reposDtoList: List<ReposDto>): List<ReposEntity> {
        val list: MutableList<ReposEntity> = mutableListOf()

        for (repos in reposDtoList) {
            list.add(
                ReposEntity(
                    id = repos.id,
                    name = repos.name
                )
            )
        }

        return list
    }

    fun exampleTest(data: Int?) = data?.plus(2)

}