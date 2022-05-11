package com.vladbstrv.githubapp

import android.app.Application
import android.content.Context
import com.vladbstrv.githubapp.di.AppDependenciesComponent
import com.vladbstrv.githubapp.di.DaggerAppDependenciesComponent

class App : Application() {

    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()

        appDependenciesComponent = DaggerAppDependenciesComponent
            .builder()
            .build()
    }
}

val Context.app: App
    get() {
        return applicationContext as App
    }