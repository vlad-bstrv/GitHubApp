package com.vladbstrv.githubapp

import com.vladbstrv.githubapp.data.retrofit.dto.ReposDto
import com.vladbstrv.githubapp.data.retrofit.dto.UserDetailDto
import com.vladbstrv.githubapp.data.retrofit.dto.UserListDto
import com.vladbstrv.githubapp.data.retrofit.utils.Mapper
import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import org.junit.Assert
import org.junit.Test

class MapperTest {
    private val mapper: Mapper = Mapper()

    private val userListDto: List<UserListDto> = listOf(
        UserListDto("login1"),
        UserListDto("login2"),
        UserListDto("login3"),
    )

    private val reposListDto: List<ReposDto> = listOf(
        ReposDto(1,"login1"),
        ReposDto(2,"login2"),
        ReposDto(3,"login3"),
    )


    @Test
    fun mapper_CorrectMapUserDetailDtoToEntity_ReturnsNotNull() {
        Assert.assertNotNull(mapper.mapUserDetailDtoToEntity(UserDetailDto(1, "", "", "")))
    }

    @Test
    fun mapper_CorrectMapUserListDtoToEntity_ReturnsTrue() {

        val expected: List<UserListEntity> = listOf(
            UserListEntity("login1"),
            UserListEntity("login2"),
            UserListEntity("login3"),
        )

        val actual: List<UserListEntity> = mapper.mapUserListDtoToEntity(userListDto)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun mapper_CorrectMapUserListDtoToEntity_ReturnsNotNull() {
        val userListEntity: List<UserListEntity> = mapper.mapUserListDtoToEntity(userListDto)
        Assert.assertNotNull(userListEntity)
    }

    @Test
    fun mapper_CorrectMapUserListDtoToEntity_ReturnsNotEquals() {
        val userListEntity: List<UserListEntity> = mapper.mapUserListDtoToEntity(listOf())
        Assert.assertNotEquals(userListDto, userListEntity)
    }

    @Test
    fun mapper_CorrectMapReposDtoToEntity_ReturnsEquals() {
        val expected: List<ReposEntity> = listOf(
            ReposEntity(1,"login1"),
            ReposEntity(2,"login2"),
            ReposEntity(3,"login3"),
        )

        val actual: List<ReposEntity> = mapper.mapReposDtoToEntity(reposListDto)

        Assert.assertEquals(expected, actual)
    }

}

