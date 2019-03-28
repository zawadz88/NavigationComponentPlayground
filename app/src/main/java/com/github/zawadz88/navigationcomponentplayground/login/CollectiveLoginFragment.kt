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
import kotlinx.android.synthetic.main.fragment_collective_login.fragmentLoginWithPasswordButton
import kotlinx.android.synthetic.main.fragment_collective_login.logMeInButton

private const val REQUEST_CODE_COLLECTIVE_LOGIN = 2

class CollectiveLoginFragment : BaseFragment(), BackNavigationListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collective_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logMeInButton.setOnClickListener {
            navigateBackWithResult(NAVIGATION_RESULT_OK)
        }
        fragmentLoginWithPasswordButton.setOnClickListener {
            navigateForResult(REQUEST_CODE_COLLECTIVE_LOGIN, CollectiveLoginFragmentDirections.actionCollectiveLoginFragmentToLoginWithPasswordFragment())
        }
    }

    override fun onNavigationResult(result: BackNavigationResult) {
        println("CollectiveLoginFragment onNavigationResult: $result")
        if (result.requestCode == REQUEST_CODE_COLLECTIVE_LOGIN && result.resultCode == NAVIGATION_RESULT_OK) {
            navigateBackWithResult(NAVIGATION_RESULT_OK)
        }
    }
}
