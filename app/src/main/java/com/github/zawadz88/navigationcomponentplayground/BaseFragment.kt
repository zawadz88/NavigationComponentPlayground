package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate: ${this::class.java.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        println("onStart: ${this::class.java.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        println("onStop: ${this::class.java.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy: ${this::class.java.simpleName}")
    }
}
