package com.aymnsaad.covidapp.data

import com.example.covidapple.data.domain.Vaccine

object DataManger {

    private val vaccineList = mutableListOf<Vaccine>()

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


}