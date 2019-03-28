package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.zawadz88.navigationcomponentplayground.login.NAVIGATION_RESULT_LOGGED_IN
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationListener
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationResult
import kotlinx.android.synthetic.main.fragment_offer.fragmentApplyButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginWithPasswordButton

private const val REQUEST_CODE_LOGIN = 1

class OfferFragment : BackNavigationListener, BaseFragment() {

    private val args: OfferFragmentArgs by navArgs()

    private val myId: Int by lazy { args.myId }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(requireContext(), "myId: $myId", Toast.LENGTH_SHORT).show()
        fragmentApplyButton.setOnClickListener { goToApply() }
        fragmentLoginWithPasswordButton.setOnClickListener {
            navigateForResult(REQUEST_CODE_LOGIN, OfferFragmentDirections.actionOfferFragmentToLoginWithPasswordFragment())
        }
        fragmentLoginButton.setOnClickListener {
            navigateForResult(REQUEST_CODE_LOGIN, OfferFragmentDirections.actionOfferFragmentToCollectiveLoginFragment())
        }
    }

    override fun onNavigationResult(result: BackNavigationResult) {
        println("OfferFragment onNavigationResult: $result")
        if ((result.requestCode == REQUEST_CODE_LOGIN && result.resultCode == NAVIGATION_RESULT_OK) ||
            result.resultCode == NAVIGATION_RESULT_LOGGED_IN
        ) {
            goToApply()
        }
    }

    private fun goToApply() {
        findNavController().navigate(OfferFragmentDirections.actionOfferFragmentToApplyFragment())
    }
}
