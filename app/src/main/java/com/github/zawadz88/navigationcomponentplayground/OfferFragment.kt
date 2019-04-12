package com.github.zawadz88.navigationcomponentplayground

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.github.zawadz88.navigationcomponentplayground.login.NAVIGATION_RESULT_LOGGED_IN
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationListener
import com.github.zawadz88.navigationcomponentplayground.navigation.BackNavigationResult
import com.github.zawadz88.navigationcomponentplayground.util.TextProducer
import kotlinx.android.synthetic.main.fragment_offer.fragmentApplyButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginButton
import kotlinx.android.synthetic.main.fragment_offer.fragmentLoginWithPasswordButton
import timber.log.Timber
import javax.inject.Inject

private const val REQUEST_CODE_LOGIN = 1

class OfferFragment
@Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val textProducer: TextProducer
) : BackNavigationListener, BaseFragment() {

    private val args: OfferFragmentArgs by navArgs()

    private val myId: Int by lazy { args.myId }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("Constructor sharedPreferences: $sharedPreferences")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initEnterTransitions()
        return inflater.inflate(R.layout.fragment_offer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(requireContext(), textProducer.produceOfferMessage(myId), Toast.LENGTH_SHORT).show()
        fragmentApplyButton.setOnClickListener { goToApply() }
        fragmentLoginWithPasswordButton.setOnClickListener {
            navigateForResultWithAnimation(REQUEST_CODE_LOGIN, OfferFragmentDirections.actionOfferFragmentToLoginWithPasswordFragment())
        }
        fragmentLoginButton.setOnClickListener {
            navigateForResultWithAnimation(REQUEST_CODE_LOGIN, OfferFragmentDirections.actionOfferFragmentToLoginNoPaswordFragment())
        }
    }

    override fun onNavigationResult(result: BackNavigationResult) {
        Timber.d("onNavigationResult: $result")
        if ((result.requestCode == REQUEST_CODE_LOGIN && result.resultCode == NAVIGATION_RESULT_OK) ||
            result.resultCode == NAVIGATION_RESULT_LOGGED_IN
        ) {
            goToApply()
        }
    }

    private fun goToApply() {
        navigateForwardWithAnimation(OfferFragmentDirections.actionOfferFragmentToApplyFragment())
    }
}
