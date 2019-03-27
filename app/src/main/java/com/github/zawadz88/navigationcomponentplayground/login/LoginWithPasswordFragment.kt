package com.github.zawadz88.navigationcomponentplayground.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zawadz88.navigationcomponentplayground.BaseFragment
import com.github.zawadz88.navigationcomponentplayground.NAVIGATION_RESULT_OK
import com.github.zawadz88.navigationcomponentplayground.R
import kotlinx.android.synthetic.main.fragment_login_with_password.logMeInButton

class LoginWithPasswordFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_with_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        logMeInButton.setOnClickListener {
            navigateBackWithResult(NAVIGATION_RESULT_OK)
        }
    }
}
