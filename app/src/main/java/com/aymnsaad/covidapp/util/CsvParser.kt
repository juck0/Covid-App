package com.aymnsaad.covidapp.util

import com.example.covidapple.data.domain.Vaccine

class CsvParser {
    fun parse(line: String): Vaccine{
        val token = line.split(",")
        return Vaccine(
         country = token[Constants.ColumnIndex.COUNTRY],
         isoCode=token[Constants.ColumnIndex.ISO_CODE],
         date=token[Constants.ColumnIndex.DATE],
         totalVaccinations=token[Constants.ColumnIndex.TOTAL_VACCINATIONS].toIntOrNull() ?: 0,
         peopleVaccinated=token[Constants.ColumnIndex.PEOPLE_VACCINATED].toIntOrNull() ?: 0,
         peopleFullyVaccinated=token[Constants.ColumnIndex.PEOPLE_FULLY_VACCINATED].toIntOrNull() ?: 0,
         dailyVaccinationsRaw=token[Constants.ColumnIndex.DAILY_VACCINATIONS_RAW].toIntOrNull() ?: 0,
         dailyVaccinations = token[Constants.ColumnIndex.DAILY_VACCINATION].toIntOrNull() ?: 0,
         totalVaccinationsPerHundred=token[Constants.ColumnIndex.TOTAL_VACCINATIONS_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
         peopleVaccinatedPerHundred=token[Constants.ColumnIndex.PEOPLE_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
         peopleFullyVaccinatedPerHundred=token[Constants.ColumnIndex.PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
         dailyVaccinationsPerMillion=token[Constants.ColumnIndex.DAILY_VACCINATIONS_PER_MILLION].toIntOrNull() ?: 0
        )
    }
}
