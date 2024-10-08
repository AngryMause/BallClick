package com.plinko

import android.app.Application
import com.plinko.di.initKoin

class PlinkoApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}