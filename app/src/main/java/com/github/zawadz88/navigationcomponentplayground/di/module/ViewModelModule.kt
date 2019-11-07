package com.github.zawadz88.navigationcomponentplayground.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.zawadz88.navigationcomponentplayground.OfferViewModel
import com.github.zawadz88.navigationcomponentplayground.di.ViewModelKey
import com.github.zawadz88.navigationcomponentplayground.di.factory.InjectingViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(OfferViewModel::class)
    abstract fun bindOfferViewModel(offerViewModel: OfferViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: InjectingViewModelFactory): ViewModelProvider.Factory
}