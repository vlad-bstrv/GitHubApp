package com.vladbstrv.githubapp

import android.app.Application
import android.content.Context
import com.vladbstrv.githubapp.data.MockUsersRepoImpl
import com.vladbstrv.githubapp.domain.repo.UsersRepo

class App : Application() {
    val usersListRepo: UsersRepo by lazy { MockUsersRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App