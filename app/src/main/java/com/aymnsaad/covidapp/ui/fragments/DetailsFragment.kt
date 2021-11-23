package com.aymnsaad.covidapp.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.aymnsaad.covidapp.R
import com.aymnsaad.covidapp.databinding.FragmentDetailsBinding


class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val LOG_TAG: String = "Info Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        addExpandAbilty(binding?.symptomsText, binding?.readMoreSymptoms)
        addExpandAbilty(binding?.preventionText, binding?.readMorePrevention)
    }

    override fun addCallBack() {

    }


    private fun addExpandAbilty(detailsText: TextView?, readMeView: TextView?) {

        readMeView?.setOnClickListener {
            val isExpand = detailsText?.maxLines == Int.MAX_VALUE
            TransitionManager.beginDelayedTransition(binding?.root as ViewGroup)
            detailsText?.maxLines = if (isExpand) 2 else Int.MAX_VALUE
            readMeView?.text = if (isExpand) "Read more" else "Show less"
        }

    }
}
