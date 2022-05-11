package com.vladbstrv.githubapp.data.retrofit.dto

import com.google.gson.annotations.SerializedName

data class UserDetailDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("login")
    val login: String,

    @SerializedName("name")
    val name: String
)
