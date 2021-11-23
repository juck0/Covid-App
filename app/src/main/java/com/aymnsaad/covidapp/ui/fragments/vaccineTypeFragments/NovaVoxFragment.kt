package com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments

import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentNovavoxBinding
import com.aymnsaad.covidapp.ui.fragments.BaseFragment

class NovaVoxFragment: BaseFragment<FragmentNovavoxBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentNovavoxBinding = FragmentNovavoxBinding::inflate
    override fun setup() {
    }
    override fun addCallBack() {
    }

    override val LOG_TAG: String = "NovaVoxFragment"
}
