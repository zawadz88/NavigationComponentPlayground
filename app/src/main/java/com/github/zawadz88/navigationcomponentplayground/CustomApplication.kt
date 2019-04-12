package com.github.zawadz88.navigationcomponentplayground

import com.github.zawadz88.navigationcomponentplayground.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class CustomApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out CustomApplication> =
        DaggerApplicationComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()

        Timber.uprootAll()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
