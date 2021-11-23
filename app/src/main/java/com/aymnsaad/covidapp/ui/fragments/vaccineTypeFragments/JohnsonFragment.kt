package com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments

import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentJohnsonAndJohnsonBinding
import com.aymnsaad.covidapp.ui.fragments.BaseFragment

class JohnsonFragment : BaseFragment<FragmentJohnsonAndJohnsonBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentJohnsonAndJohnsonBinding = FragmentJohnsonAndJohnsonBinding::inflate


    override fun setup() {}
    override fun addCallBack() {}
    override val LOG_TAG: String = "JohnsonFragment"


}
