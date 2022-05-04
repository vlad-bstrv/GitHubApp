package com.vladbstrv.githubapp.data.retrofit.dto

import com.google.gson.annotations.SerializedName

data class UserListDto(

    @SerializedName("login")
    val login: String
)
