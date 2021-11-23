package com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments

import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentSputnikVBinding
import com.aymnsaad.covidapp.ui.fragments.BaseFragment

class Sputing_v_Fragment : BaseFragment<FragmentSputnikVBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentSputnikVBinding =
        FragmentSputnikVBinding::inflate

    override fun setup() {}
    override fun addCallBack() {}
    override val LOG_TAG: String = "Sputing_v_Fragment"
}
