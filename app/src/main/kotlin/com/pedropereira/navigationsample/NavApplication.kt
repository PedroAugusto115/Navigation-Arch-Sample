package com.pedropereira.navigationsample

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk

class NavApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeHawk(this)
    }

    private fun initializeHawk(context: Context) {
        Hawk.init(context).build()
    }

}