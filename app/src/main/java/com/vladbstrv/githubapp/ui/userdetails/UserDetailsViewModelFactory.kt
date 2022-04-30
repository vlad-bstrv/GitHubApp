package com.vladbstrv.githubapp.ui.userdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vladbstrv.githubapp.domain.repo.UsersRepo


class UserDetailsViewModelFactory(private val repo: UsersRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailsViewModel(repo) as T
    }


}