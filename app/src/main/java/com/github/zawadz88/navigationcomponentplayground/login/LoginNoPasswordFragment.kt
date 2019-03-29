package com.github.zawadz88.navigationcomponentplayground.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zawadz88.navigationcomponentplayground.BaseFragment
import com.github.zawadz88.navigationcomponentplayground.NAVIGATION_RESULT_OK
import com.github.zawadz88.navigationcomponentplayground.R
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationListener
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationResult
import kotlinx.android.synthetic.main.fragment_login_no_password.fragmentLoginWithPasswordButton
import kotlinx.android.synthetic.main.fragment_login_no_password.logMeInButton
import timber.log.Timber

private const val REQUEST_CODE_COLLECTIVE_LOGIN = 2

class LoginNoPasswordFragment : BaseFragment(), BackNavigationListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initEnterTransitions()
        return inflater.inflate(R.layout.fragment_login_no_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logMeInButton.setOnClickListener {
            navigateBackWithResult(NAVIGATION_RESULT_OK)
        }
        fragmentLoginWithPasswordButton.setOnClickListener {
            navigateForResultWithAnimation(REQUEST_CODE_COLLECTIVE_LOGIN, LoginNoPasswordFragmentDirections.actionLoginNoPasswordFragmentToLoginWithPasswordFragment())
        }
    }

    override fun onNavigationResult(result: BackNavigationResult) {
        Timber.d("onNavigationResult: $result")
        if (result.requestCode == REQUEST_CODE_COLLECTIVE_LOGIN && result.resultCode == NAVIGATION_RESULT_OK) {
            navigateBackWithResult(NAVIGATION_RESULT_OK)
        }
    }
}
