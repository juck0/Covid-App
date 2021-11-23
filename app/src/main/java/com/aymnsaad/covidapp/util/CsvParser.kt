package com.aymnsaad.covidapp.util

import com.example.covidapple.data.domain.Vaccine

class CsvParser {
    fun parse(line: String): Vaccine{
        val token = line.split(",")
        return Vaccine(
            country = token[Constants.ColumnIndex.COUNTRY],
            isoCode=token[Constants.ColumnIndex.ISO_CODE],
            date=token[Constants.ColumnIndex.DATE],
            totalVaccinations=token[Constants.ColumnIndex.TOTAL_VACCINATIONS].toInt(),
            peopleVaccinated=token[Constants.ColumnIndex.PEOPLE_VACCINATED].toInt(),
            peopleFullyVaccinated=token[Constants.ColumnIndex.PEOPLE_FULLY_VACCINATED].toInt(),
            dailyVaccinationsRaw=token[Constants.ColumnIndex.DAILY_VACCINATIONS_RAW].toInt(),
            dailyVaccinations = token[Constants.ColumnIndex.DAILY_VACCINATION].toInt(),
            totalVaccinationsPerHundred=token[Constants.ColumnIndex.TOTAL_VACCINATIONS_PER_HUNDRED].toDouble(),
            peopleVaccinatedPerHundred=token[Constants.ColumnIndex.PEOPLE_VACCINATED_PER_HUNDRED].toDouble(),
            peopleFullyVaccinatedPerHundred=token[Constants.ColumnIndex.PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDouble(),
            dailyVaccinationsPerMillion=token[Constants.ColumnIndex.DAILY_VACCINATIONS_PER_MILLION].toInt()
        )
    }
}