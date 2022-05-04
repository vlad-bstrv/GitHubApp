package com.vladbstrv.githubapp.ui.userdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.githubapp.domain.entity.ReposEntity
import com.vladbstrv.githubapp.domain.entity.UserDetailEntity
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserDetailsViewModel(private val usersListRepo: UsersRepo) : ViewModel() {

    private val _userDetails = MutableLiveData<UserDetailEntity>()
    val userDetails: LiveData<UserDetailEntity> = _userDetails

    private val _repos = MutableLiveData<List<ReposEntity>>()
    val repos: LiveData<List<ReposEntity>> = _repos

    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onShowUserDetails(username: String) {
        _inProgress.postValue(true)
        compositeDisposable.add(
            usersListRepo
                .observeUsersDetails(username)
                .subscribeBy {
                    _userDetails.postValue(it)
                    _inProgress.postValue(false)
                }
        )
    }

    fun onShowRepos(username: String) {
        compositeDisposable.add(
            usersListRepo
                .observeRepos(username)
                .subscribeBy {
                    _repos.postValue(it)
                }
        )
    }
}