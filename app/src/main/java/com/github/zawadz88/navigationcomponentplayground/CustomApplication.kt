package com.github.zawadz88.navigationcomponentplayground

import android.app.Application
import com.github.zawadz88.navigationcomponentplayground.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class CustomApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector


    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.factory().create(this).inject(this)

        Timber.uprootAll()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
