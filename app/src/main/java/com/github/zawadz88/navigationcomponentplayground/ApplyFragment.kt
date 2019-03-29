package com.github.zawadz88.navigationcomponentplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.appbar.toolbar

class ApplyFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initEnterTransitions()
        return inflater.inflate(R.layout.fragment_apply, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            toolbar.setNavigationIcon(R.drawable.ic_clear)
        } else {
            val animatedIconDrawable = checkNotNull(AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.avd_back_to_clear)) { "Could not create animated vector" }
            animatedIconDrawable.setTint(ContextCompat.getColor(requireContext(), R.color.toolbarColorControlNormal))
            animatedIconDrawable.start()
            toolbar.navigationIcon = animatedIconDrawable
        }
    }
}
