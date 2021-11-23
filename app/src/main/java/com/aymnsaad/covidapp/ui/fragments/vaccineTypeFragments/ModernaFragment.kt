package com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments

import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentModernaBinding
import com.aymnsaad.covidapp.ui.fragments.BaseFragment

class ModernaFragment : BaseFragment<FragmentModernaBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentModernaBinding = FragmentModernaBinding::inflate
    override fun setup() {
    }
    override fun addCallBack() {
    }

    override val LOG_TAG: String = "ModernaFragment"
}
