package com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments

import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentSinopharmBinding
import com.aymnsaad.covidapp.ui.fragments.BaseFragment

class SinopharmFragment : BaseFragment<FragmentSinopharmBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentSinopharmBinding = FragmentSinopharmBinding::inflate


    override fun setup() {}
    override fun addCallBack() {}
    override val LOG_TAG: String = "SinopharmFragment"


}
