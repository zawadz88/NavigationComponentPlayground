package com.github.zawadz88.navigationcomponentplayground.login

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.navigation.fragment.findNavController
import com.github.zawadz88.navigationcomponentplayground.BaseFragment
import com.github.zawadz88.navigationcomponentplayground.R

const val NAVIGATION_RESULT_LOGGED_IN = 123

class DeepLinkLoginFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deep_link_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // imitates a successful login
        Handler().postDelayed(3000L) {
            if (navigateBackWithResult(destination = R.id.loginNoPasswordFragment, resultCode = NAVIGATION_RESULT_LOGGED_IN)) return@postDelayed
            if (navigateBackWithResult(destination = R.id.loginWithPasswordFragment, resultCode = NAVIGATION_RESULT_LOGGED_IN)) return@postDelayed
            findNavController().popBackStack()
        }
    }
}
