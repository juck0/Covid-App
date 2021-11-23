package com.aymnsaad.covidapp.ui.fragments

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.aymnsaad.covidapp.R
import com.aymnsaad.covidapp.databinding.FragmentVaccineTypeBinding
import com.aymnsaad.covidapp.ui.fragments.vaccineTypeFragments.*

class VaccineTypeFragment() : BaseFragment<FragmentVaccineTypeBinding>() {

    override val LOG_TAG: String = "VaccineTypeFragment"
    private var mySputnikFragment =  Sputing_v_Fragment()
    private var myAstazanikaFragment = AstazanikaFragment()
    private var myPfizerFragment = PfizerFragment()
    private val myModernaFragment = ModernaFragment()
    private val mySinopharmFragment = SinopharmFragment()
    private val myJohnsonJohnsonFragment = JohnsonFragment()
    private val myNovaVoxFragment = NovaVoxFragment()
    override val bindingInflater: (LayoutInflater) -> FragmentVaccineTypeBinding = FragmentVaccineTypeBinding::inflate
    override fun setup() {}
    override fun addCallBack() {
        binding?.apply {
            VizorType1.setOnClickListener {
                condition(myPfizerFragment)
            }
            sputnikType2.setOnClickListener {
                condition(mySputnikFragment)
            }
            astaType3.setOnClickListener {
                condition(myAstazanikaFragment)
            }
            modernaType4.setOnClickListener {
                condition(myModernaFragment)
            }
            novavaxType5.setOnClickListener {
                condition(mySinopharmFragment)
            }
            jhonsonType6.setOnClickListener {
                condition(myJohnsonJohnsonFragment)
            }
            senphormType7.setOnClickListener {
                condition(myNovaVoxFragment)
            }
        }
    }
     private fun addFragment(fragment : Fragment){
        val trans = activity?.supportFragmentManager?.beginTransaction()
        trans?.add(R.id.fragmentCountainerVaccine,fragment)
        trans?.commit()
    }
     private fun replaceFragment(fragment : Fragment){
        val trans = activity?.supportFragmentManager?.beginTransaction()
        trans?.replace(R.id.fragmentCountainerVaccine,fragment)
        trans?.commit()
    }
    private fun condition(fragment: Fragment){
        replaceFragment(fragment)
    }
}
