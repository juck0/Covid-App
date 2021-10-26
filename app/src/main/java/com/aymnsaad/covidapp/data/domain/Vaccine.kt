package com.example.covidapple.data.domain

data class Vaccine(
    val country: String?,
    val isoCode: String?,
    val date: String?,
    val totalVaccinations: Int?,
    val peopleVaccinated: Int?,
    val peopleFullyVaccinated: Int?,
    val dailyVaccinationsRaw: Int?,
    val dailyVaccinations: Int?,
    val totalVaccinationsPerHundred: Double?,
    val peopleVaccinatedPerHundred: Double?,
    val peopleFullyVaccinatedPerHundred: Double?,
    val dailyVaccinationsPerMillion: Int?
)