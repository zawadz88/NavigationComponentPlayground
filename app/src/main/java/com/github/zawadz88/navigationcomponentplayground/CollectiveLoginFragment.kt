package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_collective_login.fragmentLoginWithPasswordButton
import kotlinx.android.synthetic.main.fragment_collective_login.logMeInButton

class CollectiveLoginFragment : BaseFragment() {

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
            findNavController().popBackStack()
        }
        fragmentLoginWithPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_collectiveLoginFragment_to_loginWithPasswordFragment)
        }
    }
}
