package com.aymnsaad.covidapp.ui.fragments

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import com.aymnsaad.covidapp.data.domain.Data
import com.aymnsaad.covidapp.databinding.FragmentHomeBinding
import com.example.covidapple.data.domain.TopCountries

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "Home Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
    override fun setup() {
        getData()
        getTopCountryNumber()
    }

    override fun addCallBack() {
        binding?.reedMeButton?.setOnClickListener {
            learnMore()
        }
    }

    private fun learnMore(){
        var readMoreArticle:String = "https://www.hopkinsmedicine.org/health/conditions-and-diseases/coronavirus"
        var intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(readMoreArticle)
        startActivity(intent)
    }

    fun getData(){
        binding?.confirmedNumber?.text = Data.CONFIRMED.v
        binding?.deathsNumber?.text = Data.DEATHS.v
        binding?.recoverNumber?.text = Data.RECOVER.v

    }
    fun getTopCountryNumber(){
        binding?.firstCountryNumber?.text = TopCountries.FRANCE.s
        binding?.secondCountryNumber?.text = TopCountries.ITALY.s
        binding?.thirdCountryNumber?.text = TopCountries.TURKEY.s
        binding?.fourthCountryNumber?.text = TopCountries.RUSSIA.s
        binding?.fifthCountryNumber?.text = TopCountries.INDIA.s

    }
}