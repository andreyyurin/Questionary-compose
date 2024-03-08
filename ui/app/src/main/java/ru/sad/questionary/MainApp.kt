package ru.sad.questionary

import android.app.Application
import com.chibatching.kotpref.Kotpref
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKotpref()
    }

    private fun initKotpref() {
        Kotpref.init(this)
    }
}