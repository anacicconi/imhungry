package com.example.android.imhungry

import android.app.Application
import timber.log.Timber

// The app class is used for things that are necessary all over the app (e.g:logs) and that need to be set before all the other things (activities and fragments)
class ImHungryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
