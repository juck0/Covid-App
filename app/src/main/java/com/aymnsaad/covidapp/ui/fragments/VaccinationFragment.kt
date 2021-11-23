package com.aymnsaad.covidapp.ui.fragments

import android.view.LayoutInflater
import com.aymnsaad.covidapp.data.DataManger
import com.aymnsaad.covidapp.databinding.FragmentVaccinationBinding

class VaccinationFragment : BaseFragment<FragmentVaccinationBinding>() {
    override val LOG_TAG: String = "Vaccination Activity"

    override val bindingInflater: (LayoutInflater) -> FragmentVaccinationBinding
        get() = FragmentVaccinationBinding::inflate


    override fun setup() {
        var counter = 0
        val listOfCountry = DataManger.getTotalVaccinationForAllCountries().toList()
        for (i in listOfCountry.indices) {
            counter++
            binding?.textview?.append((counter.toString() + "." + listOfCountry[i].first?.take(20) + "\t\t\t \b" + listOfCountry[i].second + "\n"))

        }
    }

    override fun addCallBack() {

    }
}
