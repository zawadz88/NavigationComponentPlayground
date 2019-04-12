package com.github.zawadz88.navigationcomponentplayground.util

import javax.inject.Inject

class TextProducer
@Inject constructor() {

    fun produceOfferMessage(id: Int): String = "I am an offer with ID: $id"
}
