package com.github.zawadz88.navigationcomponentplayground.di

import android.app.Application
import com.github.zawadz88.navigationcomponentplayground.CustomApplication
import com.github.zawadz88.navigationcomponentplayground.di.module.AppModule
import com.github.zawadz88.navigationcomponentplayground.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }

    fun inject(customApp: CustomApplication)
}
