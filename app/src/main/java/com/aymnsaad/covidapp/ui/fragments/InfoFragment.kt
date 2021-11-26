package com.aymnsaad.covidapp.ui.fragments

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import com.aymnsaad.covidapp.databinding.FragmentInfoBinding


class InfoFragment: BaseFragment<FragmentInfoBinding>() {
    override val LOG_TAG: String = "Info Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentInfoBinding
        get() = FragmentInfoBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {
        var url:String
        binding?.buttonGithubEnas?.setOnClickListener{
                url="https://github.com/Rafal-a"
                gitHubAccount(url)
        }
        binding?.buttonGithubAymn?.setOnClickListener {
            url = "https://github.com/juck0"
            gitHubAccount(url)
        }


    }
    private fun gitHubAccount(url:String){
        var intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}