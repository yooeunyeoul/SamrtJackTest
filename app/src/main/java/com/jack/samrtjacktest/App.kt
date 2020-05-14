package com.jack.samrtjacktest

import com.jack.samrtjacktest.di.AppComponent
import com.jack.samrtjacktest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }


    override fun applicationInjector(): AppComponent? {

        val appComponent = DaggerAppComponent.builder().application(this)?.build()
        appComponent?.inject(this)
        return appComponent
    }

}