package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment

class InstantiatingNavHostFragment: NavHostFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO: 2019-04-11 inject with Dagger instead as in https://github.com/alex-townsend/FragmentFactoryDaggerSample
        childFragmentManager.fragmentFactory = object : FragmentFactory() {
            override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
                if (OfferFragment::class.java.name == className) {
                    return OfferFragment("XXX")
                }
                return super.instantiate(classLoader, className)
            }
        }
        super.onCreate(savedInstanceState)
    }
}
