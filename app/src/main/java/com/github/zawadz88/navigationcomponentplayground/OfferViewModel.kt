package com.github.zawadz88.navigationcomponentplayground

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class OfferViewModel @Inject constructor(): ViewModel(){
    init {
        Timber.d("I was created")
    }
}