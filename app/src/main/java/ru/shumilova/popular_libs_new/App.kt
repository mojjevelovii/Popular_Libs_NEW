package ru.shumilova.popular_libs_new

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        var application: App? = null
    }
}