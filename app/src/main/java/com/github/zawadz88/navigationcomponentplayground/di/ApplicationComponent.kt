package com.github.zawadz88.navigationcomponentplayground.di

import com.github.zawadz88.navigationcomponentplayground.CustomApplication
import com.github.zawadz88.navigationcomponentplayground.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<CustomApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<CustomApplication>
}
