package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_offer.fragmentApplyButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginWithPasswordButton

class OfferFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentApplyButton.setOnClickListener {
            findNavController().navigate(R.id.action_offerFragment_to_applyFragment)
        }
        fragmentLoginWithPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_offerFragment_to_loginWithPasswordFragment)
        }
        fragmentLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_offerFragment_to_collectiveLoginFragment)
        }
    }

}
