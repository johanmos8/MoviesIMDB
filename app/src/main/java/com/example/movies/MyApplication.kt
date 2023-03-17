package com.example.movies

import android.app.Application
import com.example.movies.data.di.dataModule
import com.example.movies.domain.di.domainModule
import com.example.movies.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                presentationModule, domainModule, dataModule
            )
        }
    }
}
