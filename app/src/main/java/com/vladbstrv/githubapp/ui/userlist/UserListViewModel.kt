package com.vladbstrv.githubapp.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserListViewModel(private val usersListRepo: UsersRepo) : ViewModel() {

    private val _repos = MutableLiveData<List<UserListEntity>>()
    val repos: LiveData<List<UserListEntity>> = _repos

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onShowRepos() {
        compositeDisposable.add(
            usersListRepo
                .observeUsersList()
                .subscribeBy {
                    _repos.postValue(it)
                }
        )
    }
}