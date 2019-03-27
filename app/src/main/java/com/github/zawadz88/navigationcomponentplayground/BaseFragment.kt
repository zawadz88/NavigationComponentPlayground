package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationListener
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationResult
import kotlin.properties.Delegates

private const val REQUEST_CODE_NOT_SET = -1

const val NAVIGATION_RESULT_CANCELED = 0

const val NAVIGATION_RESULT_OK = -1

private const val NAVIGATION_REQUEST_CODE = "NAVIGATION_REQUEST_CODE"

abstract class BaseFragment : Fragment() {

    private val requestCode: Int
        get() = arguments?.getInt(NAVIGATION_REQUEST_CODE, REQUEST_CODE_NOT_SET) ?: REQUEST_CODE_NOT_SET

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

    protected fun navigateForResult(
        @IdRes resId: Int, requestCode: Int, args: Bundle? = null, navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    ) {
        val argsWithRequestCode = (args ?: Bundle()).apply {
            putInt(NAVIGATION_REQUEST_CODE, requestCode)
        }
        findNavController().navigate(resId, argsWithRequestCode, navOptions, navigatorExtras)
    }

    protected fun navigateBackWithResult(resultCode: Int, data: Bundle? = null) {
        navigateBackWithResult(BackNavigationResult(requestCode, resultCode, data))
    }

    private fun navigateBackWithResult(result: BackNavigationResult) {
        val childFragmentManager = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.childFragmentManager
        var backStackListener: FragmentManager.OnBackStackChangedListener by Delegates.notNull()
        backStackListener = FragmentManager.OnBackStackChangedListener {
            (childFragmentManager?.fragments?.get(0) as? BackNavigationListener)?.onNavigationResult(result)
            childFragmentManager?.removeOnBackStackChangedListener(backStackListener)
        }
        childFragmentManager?.addOnBackStackChangedListener(backStackListener)
        findNavController().popBackStack()
    }
}
