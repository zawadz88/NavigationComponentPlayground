package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationListener
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationResult
import kotlinx.android.synthetic.main.appbar.appBarLayout
import kotlinx.android.synthetic.main.appbar.toolbar
import timber.log.Timber
import kotlin.properties.Delegates

private const val ARGUMENT_NAVIGATION_REQUEST_CODE = "NAVIGATION_REQUEST_CODE"

const val DESTINATION_NOT_SET = -1
const val REQUEST_CODE_NOT_SET = -1

const val NAVIGATION_RESULT_CANCELED = 0
const val NAVIGATION_RESULT_OK = -1

abstract class BaseFragment : Fragment() {

    protected open val hasUpNavigation: Boolean = true

    private val requestCode: Int
        get() = arguments?.getInt(ARGUMENT_NAVIGATION_REQUEST_CODE, REQUEST_CODE_NOT_SET) ?: REQUEST_CODE_NOT_SET

    private val appBarTransition: String by lazy { requireActivity().getString(R.string.transition_name_appbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate: ${this::class.java.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart: ${this::class.java.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop: ${this::class.java.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy: ${this::class.java.simpleName}")
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toolbar?.apply {
            title = findNavController().currentDestination?.label
            if (!hasUpNavigation) return@apply

            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener { navigateUp() }
        }
    }

    protected fun navigateForResultWithAnimation(
        requestCode: Int, navDirections: NavDirections, navOptions: NavOptions? = null
    ) {
        val extras = FragmentNavigatorExtras(appBarLayout to appBarTransition)
        this.exitTransition = Fade()
        navigateForResult(
            resId = navDirections.actionId,
            requestCode = requestCode,
            args = navDirections.arguments,
            navOptions = navOptions,
            navigatorExtras = extras
        )
    }

    protected fun navigateForResult(
        requestCode: Int, navDirections: NavDirections, navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    ) =
        navigateForResult(
            resId = navDirections.actionId,
            requestCode = requestCode,
            args = navDirections.arguments,
            navOptions = navOptions,
            navigatorExtras = navigatorExtras
        )

    protected fun navigateForResult(
        @IdRes resId: Int, requestCode: Int, args: Bundle? = null, navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    ) {
        val argsWithRequestCode = (args ?: Bundle()).apply {
            putInt(ARGUMENT_NAVIGATION_REQUEST_CODE, requestCode)
        }
        findNavController().navigate(resId, argsWithRequestCode, navOptions, navigatorExtras)
    }

    protected fun navigateForwardWithAnimation(navDirections: NavDirections) {
        val extras = FragmentNavigatorExtras(appBarLayout to appBarTransition)
        this.exitTransition = Fade()
        findNavController().navigate(navDirections, extras)
    }

    protected fun navigateBackWithResult(resultCode: Int, data: Bundle? = null): Boolean =
        navigateBackWithResult(DESTINATION_NOT_SET, BackNavigationResult(requestCode, resultCode, data))

    protected fun navigateBackWithResult(@IdRes destination: Int, resultCode: Int, data: Bundle? = null): Boolean =
        navigateBackWithResult(destination, BackNavigationResult(requestCode, resultCode, data))

    protected fun navigateUp(): Boolean = findNavController().navigateUp()

    protected fun initEnterTransitions() {
        sharedElementEnterTransition = ChangeBounds()
        enterTransition = Fade()
    }

    private fun navigateBackWithResult(@IdRes destination: Int, result: BackNavigationResult): Boolean {
        val childFragmentManager = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.childFragmentManager
        var backStackListener: FragmentManager.OnBackStackChangedListener by Delegates.notNull()
        backStackListener = FragmentManager.OnBackStackChangedListener {
            (childFragmentManager?.fragments?.get(0) as? BackNavigationListener)?.onNavigationResult(result)
            childFragmentManager?.removeOnBackStackChangedListener(backStackListener)
        }
        childFragmentManager?.addOnBackStackChangedListener(backStackListener)
        val backStackPopped = if (destination == DESTINATION_NOT_SET) {
            findNavController().popBackStack()
        } else {
            findNavController().popBackStack(destination, true)
        }
        if (!backStackPopped) {
            childFragmentManager?.removeOnBackStackChangedListener(backStackListener)
        }
        return backStackPopped
    }
}
