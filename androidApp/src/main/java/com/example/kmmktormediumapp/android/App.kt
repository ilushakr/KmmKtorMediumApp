package com.example.kmmktormediumapp.android

import android.app.Application
import com.example.kmmktormediumapp.di.sharedBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(sharedBase())
        }
    }
}