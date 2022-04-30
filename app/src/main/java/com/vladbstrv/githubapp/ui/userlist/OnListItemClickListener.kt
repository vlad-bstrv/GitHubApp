package com.vladbstrv.githubapp.ui.userlist

import com.vladbstrv.githubapp.domain.entity.UserListEntity

interface OnListItemClickListener {
    fun onItemClick(data: UserListEntity)
}