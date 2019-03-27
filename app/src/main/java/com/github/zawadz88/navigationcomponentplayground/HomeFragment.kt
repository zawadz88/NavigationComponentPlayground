package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.fragmentLoginButton
import kotlinx.android.synthetic.main.fragment_home.fragmentLoginWithPasswordButton
import kotlinx.android.synthetic.main.fragment_home.fragmentOfferButton

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_collectiveLoginFragment)
        }
        fragmentLoginWithPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginWithPasswordFragment)
        }
        fragmentOfferButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_offerFragment)
        }
    }
}
