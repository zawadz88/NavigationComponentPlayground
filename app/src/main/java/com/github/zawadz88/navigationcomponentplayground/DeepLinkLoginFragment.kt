package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.navigation.fragment.findNavController

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
            // TODO: 27/03/2019 go to Apply offer
            val navController = findNavController()
            if (navController.popBackStack(R.id.collectiveLoginFragment, true)) return@postDelayed
            if (navController.popBackStack(R.id.loginWithPasswordFragment, true)) return@postDelayed
            navController.popBackStack()
        }
    }
}
