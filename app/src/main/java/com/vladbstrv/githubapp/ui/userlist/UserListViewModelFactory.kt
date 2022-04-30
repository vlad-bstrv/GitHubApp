package com.vladbstrv.githubapp.ui.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vladbstrv.githubapp.ui.domain.repo.UsersListRepo


class UserListViewModelFactory(private val repo: UsersListRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(repo) as T
    }


}