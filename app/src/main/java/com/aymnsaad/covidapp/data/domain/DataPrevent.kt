package com.aymnsaad.covidapp.data.domain

import com.aymnsaad.covidapp.R

object DataPrevent {
    val listData = listOf<CovidPrevent>(
        CovidPrevent(
            "Hand Wash" ,
            "Wash your hands often with soap and water for at least 20 second especially after you have been in a public place.",
            R.drawable.subtraction1,
            R.drawable.washhand
        ),
        CovidPrevent(
            "Wear Masks",
            "Masks should be worn in addition to staying at least 6 feet apart, especially around people who don't live with you.",
            R.drawable.subtraction2,
            R.drawable.last
        ),
        CovidPrevent(
            "Safe distance",
            "Maintain a safe distance from others, even if they don’t appear to be sick.",
            R.drawable.subtraction3,
            R.drawable.distancing
        ),
        CovidPrevent(
            "Cover your mouth",
            "Always cover your mouth and nose with a tissue when you cough or sneeze or use the inside of your elbow and do not spit.",
            R.drawable.subtraction5,
            R.drawable.maintain,

            ),
        CovidPrevent(
            "Get Vaccinated",
            "Get vaccinated when it’s your turn. Follow local guidance about vaccination.",
            R.drawable.subtraction6,
            R.drawable.last21
        )
    )
}
