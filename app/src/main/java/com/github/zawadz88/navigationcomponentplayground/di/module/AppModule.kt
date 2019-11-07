package com.github.zawadz88.navigationcomponentplayground.di.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.github.zawadz88.navigationcomponentplayground.CustomApplication
import com.github.zawadz88.navigationcomponentplayground.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class AppModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideSharedPreferences(
            app: Application
        ): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)
    }
}
