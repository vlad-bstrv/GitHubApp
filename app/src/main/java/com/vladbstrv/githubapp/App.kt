package com.vladbstrv.githubapp

import android.app.Application
import android.content.Context
import com.vladbstrv.githubapp.ui.data.MockUsersListRepoImpl
import com.vladbstrv.githubapp.ui.domain.repo.UsersListRepo

class App : Application() {
    val usersListRepo: UsersListRepo by lazy { MockUsersListRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App