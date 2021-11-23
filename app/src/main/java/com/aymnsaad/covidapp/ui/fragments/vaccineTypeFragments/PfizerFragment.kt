package com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments

import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentPfizerBinding
import com.aymnsaad.covidapp.ui.fragments.BaseFragment

class PfizerFragment : BaseFragment<FragmentPfizerBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentPfizerBinding = FragmentPfizerBinding::inflate
    override fun setup() {

    }

    override fun addCallBack() {
    }

    override val LOG_TAG: String = "PfizerFragment"


}
