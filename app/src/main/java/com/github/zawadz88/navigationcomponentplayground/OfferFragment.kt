package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationListener
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationResult
import kotlinx.android.synthetic.main.fragment_offer.fragmentApplyButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginWithPasswordButton

private const val REQUEST_CODE_LOGIN = 1

class OfferFragment : BackNavigationListener, BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentApplyButton.setOnClickListener { goToApply() }
        fragmentLoginWithPasswordButton.setOnClickListener {
            navigateForResult(R.id.action_offerFragment_to_loginWithPasswordFragment, REQUEST_CODE_LOGIN)
        }
        fragmentLoginButton.setOnClickListener {
            navigateForResult(R.id.action_offerFragment_to_collectiveLoginFragment, REQUEST_CODE_LOGIN)
        }
    }

    override fun onNavigationResult(result: BackNavigationResult) {
        if (result.requestCode == REQUEST_CODE_LOGIN && result.resultCode == NAVIGATION_RESULT_OK) {
            goToApply()
        }
    }

    private fun goToApply() {
        findNavController().navigate(R.id.action_offerFragment_to_applyFragment)
    }
}
