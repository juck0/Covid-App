package com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments
import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentAstazanikaBinding
import com.aymnsaad.covidapp.ui.fragments.BaseFragment


class AstazanikaFragment : BaseFragment<FragmentAstazanikaBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentAstazanikaBinding = FragmentAstazanikaBinding::inflate
    override fun setup() {
    }
    override fun addCallBack() {
    }

    override val LOG_TAG: String
        get() = TODO("Not yet implemented")
}
