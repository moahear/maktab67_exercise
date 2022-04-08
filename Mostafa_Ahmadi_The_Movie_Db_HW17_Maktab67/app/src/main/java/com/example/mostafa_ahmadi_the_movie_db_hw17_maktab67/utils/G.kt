package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.utils

import android.app.Application
import timber.log.Timber

class G: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}