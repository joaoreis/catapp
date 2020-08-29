package com.joaoreis.catapp

import android.app.Application
import com.joaoreis.catapp.featurea.di.featureAModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CatApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@CatApplication)
            modules(featureAModule)
        }
    }
}
