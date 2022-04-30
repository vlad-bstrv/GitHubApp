package com.vladbstrv.githubapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vladbstrv.githubapp.R
import com.vladbstrv.githubapp.ui.userlist.UserListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, UserListFragment())
            .commit()
    }
}