package com.vladbstrv.githubapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vladbstrv.githubapp.R
import com.vladbstrv.githubapp.ui.userdetails.UserDetailsFragment
import com.vladbstrv.githubapp.ui.userlist.UserListFragment

class MainActivity : AppCompatActivity(), UserListFragment.Controller {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, UserListFragment())
            .commit()
    }

    override fun openDetailScreen(username: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack("")
            .replace(R.id.container, UserDetailsFragment.newInstance(username))
            .commit()
    }
}