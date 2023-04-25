package com.alessandrofarandagancio.geckowrapper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ThisApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}