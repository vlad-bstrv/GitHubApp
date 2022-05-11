package com.vladbstrv.githubapp.data.retrofit.dto

import com.google.gson.annotations.SerializedName

data class ReposDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)