package com.aymnsaad.covidapp.ui.fragments

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.aymnsaad.covidapp.R
import com.aymnsaad.covidapp.data.DataManger
import com.aymnsaad.covidapp.databinding.FragmentSearchBinding
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    override fun setup() {
        binding?.apply {
            inputCountryText.isIconified = false
            inputCountryText.setOnQueryTextListener(object :
                android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(search: String?): Boolean {
                    searchSubmit(requireNotNull(search))
                    return false
                }

                override fun onQueryTextChange(newSearch: String?): Boolean {
                    searchTextChange(requireNotNull(newSearch))
                    return false
                }
            })
        }
    }
    private fun searchSubmit(country: String) {
        binding?.apply {
            visibility(true)
            if (country.isEmpty() || DataManger.getCountry(country.lowercase().trim())
                        [country.lowercase().trim()].isNullOrEmpty()
            ) {
                lottieError.visibility = View.VISIBLE
                visibility(false)
            } else {
                setData(country)
                visibility(true)
            }
            lottieSearch.isVisible = false
        }
    }
    private fun searchTextChange(newText: String) {
        binding?.apply {
            lottieError.visibility = View.GONE
            visibility(false)
            lottieSearch.isVisible = true
            lineChart.isVisible = false
        }
    }
    private fun setData(country: String) {
        DataManger.getCountry(country).forEach { dataCountry ->
            val data = dataCountry.value[dataCountry.value.size - 1]

            binding?.apply {
                txtPeopleVaccine.text = data.peopleVaccinated?.let { DataManger.convertNumber(it.toDouble()) }
                txtPeopleFullyVaccine.text = data.peopleFullyVaccinated?.let {
                    DataManger.convertNumber(it.toDouble())
                }
                "${data.peopleVaccinatedPerHundred}%".also { txtPeopleVaccinePerHundred.text = it }
                "${data.peopleFullyVaccinatedPerHundred}%".also { txtPeopleFullyVaccinePerHundred.text = it }
                txtCountryName.text = data.country
            }
        }
        chartDataSet(country)
    }
    private fun chartDataSet(country: String){
        val data = DataManger.getDailyVaccine(country)
        val aaChartView = binding?.lineChart
        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Area)
            .title("Daily Vaccination")
            .titleStyle(AAStyle().color("#008000"))
            .backgroundColor(resources.getColor(R.color.white))
            .dataLabelsEnabled(true)
            .legendEnabled(false)
            .yAxisTitle("vaccination")
            .yAxisLabelsEnabled(false)
            .categories(arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"))
            .series(arrayOf(
                AASeriesElement()
                    .name(country)
                    .enableMouseTracking(true)
                    .data(arrayOf(data[1], data[data.size-125], data[data.size-110], data[data.size-90], data[data.size-75], data[data.size-40], data[data.size-20], data[data.size-1])),
            )
            )
            .animationDuration(3000)
        aaChartView?.aa_drawChartWithChartModel(aaChartModel)
        aaChartView?.aa_updateChartWithOptions(aaChartModel,true)

    }
    override fun addCallBack() {
        visibility(false)
    }
    private fun visibility(state: Boolean) {
        binding?.apply {
            cardCountry.isVisible = state
            txtCountryName.isVisible =state
            txtPeopleFullyVaccine.isVisible =state
            txtPeopleVaccinePerHundred.isVisible =state
            txtPeopleFullyVaccinePerHundred.isVisible =state
            labPeopleVaccine.isVisible =state
            labPeopleFullyVaccine.isVisible =state
            txtPeopleVaccine.isVisible =state
            lottieSearch.isVisible = !state
            lineChart.isVisible = state
            chartCard.isVisible = state
        }
    }

    override val LOG_TAG: String
        get() = "Search"
}