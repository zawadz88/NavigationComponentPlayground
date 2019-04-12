package com.github.zawadz88.navigationcomponentplayground.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.zawadz88.navigationcomponentplayground.OfferFragment
import com.github.zawadz88.navigationcomponentplayground.di.FragmentKey
import com.github.zawadz88.navigationcomponentplayground.di.factory.InjectingFragmentFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(OfferFragment::class)
    abstract fun bindMainFragment(mainFragment: OfferFragment): Fragment

    @Binds
    abstract fun bindFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory
}
