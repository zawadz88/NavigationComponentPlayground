package com.github.zawadz88.navigationcomponentplayground.di.module

import com.github.zawadz88.navigationcomponentplayground.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [NavHostModule::class])
    abstract fun mainActivityInjector(): MainActivity
}