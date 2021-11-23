package com.aymnsaad.covidapp.data

import com.example.covidapple.data.domain.Vaccine

object DataManger {

    private val vaccineList = mutableListOf<Vaccine>()
    private var countryList = mutableListOf<Vaccine>()
    /**
     * This function fill the list of Vaccine
     */
    fun addVaccine(vaccine: Vaccine) = vaccineList.add(vaccine)

    /**
     * this function take one parameter and return TotalDailyVaccinationForCountry
     * @param country
     */
    fun getTotalDailyVaccinationForCountry(country: String?) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.sumOf { it.dailyVaccinations ?: 0 }

    /**
     * this function take one parameter and return TotalVaccinatedForCountry
     * @param country
     */
    fun getTotalVaccinatedForCountry(country: String?) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.sumOf { it.peopleFullyVaccinated ?: 0}
    /**
     * this function take no parameter and return TotalVaccinationForAllCountries
     * take the top 5.
     */
    fun getTotalVaccinationForAllCountries() = vaccineList.groupBy {
        it.country
    }.keys.associateWith { getTotalDailyVaccinationForCountry(it) }
    /**
     * this function take no parameter and return TotalVaccinatedForAllCountries
     */
    fun getTotalVaccinatedForAllCountries() = vaccineList.groupBy {
        it.country
    }.keys.associateWith { getTotalVaccinatedForCountry(it) }.toList().sortedBy { (_,v) -> v* -1  }.take(5).toMap()

    /**
     * this function take one parameter and return VaccinationMapOfCountry
     * @param country
     */

    fun getVaccinationMapOfCountry(country: String) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.associate {
        Pair(it.date, it.dailyVaccinations)
    }.toList().sortedBy { (_,v) -> v }.toMap()

    fun getCountry(country: String) = vaccineList.let {
        countryList = it.filter { it1 ->
            it1.country?.lowercase()?.trim() == country.lowercase().trim()
        }.toMutableList()

        it.associateBy(
            keySelector = { country.lowercase().trim() },
            valueTransform = { countryList }
        )
    }
    // initCountryList filter vaccineList according to country to create new list content only last row of data

    // function to convert big numbers to K , M and B style
    fun convertNumber(number: Double): String {
        return when {
            (number / 1000000000) >= 1 -> {
                val number1 =number / 1000000000
                String.format("%.3f", number1) + "B"
            }
            (number / 1000000) >= 1 -> {
                val number1 =number / 1000000
                String.format("%.2f", number1) + "M"
            }
            (number / 1000) >= 1 -> {
                ((number / 1000).toInt()).toString() + "K"
            }
            else -> {
                number.toString()
            }
        }
    }

    fun getDailyVaccine(country: String): MutableList<Double> {
        val list = mutableListOf<Double>()
        vaccineList.forEach {
            if (it.country?.lowercase()?.trim() == country.lowercase().trim()){
                it.dailyVaccinations?.let { it1 -> list.add(it1.toDouble()) }
            }
        }
        return list
    }
}