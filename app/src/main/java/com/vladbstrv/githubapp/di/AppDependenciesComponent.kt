package com.vladbstrv.githubapp.di

import com.vladbstrv.githubapp.ui.userdetails.UserDetailsFragment
import com.vladbstrv.githubapp.ui.userlist.UserListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppNetworkModule::class
    ]
)

interface AppDependenciesComponent {
    fun inject(userListFragment: UserListFragment)
    fun inject(userDetailsFragment: UserDetailsFragment)

}