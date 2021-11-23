package com.aymnsaad.covidapp.ui.fragments

import android.view.LayoutInflater
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.aymnsaad.covidapp.data.domain.DataPrevent
import com.aymnsaad.covidapp.databinding.FragmentCovidPreventBinding
import com.aymnsaad.covidapp.util.ViewPagerAdapter


class CovidPreventFragment : BaseFragment<FragmentCovidPreventBinding>() {
    override val LOG_TAG: String = "CovidPreventFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentCovidPreventBinding
        get() = FragmentCovidPreventBinding::inflate

    override fun setup() {
        viewPagerAdapter()
    }

    override fun addCallBack() {
        onClickNext()
    }

    private fun viewPagerAdapter() {
        binding?.myViewPager?.apply {
            this.adapter = ViewPagerAdapter(DataPrevent.listData)
            this.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            this.apply {
                beginFakeDrag()
                fakeDragBy(10f)
                endFakeDrag()
            }
            binding?.myindecator?.setViewPager(this)
        }
    }

    private fun onClickNext() {

        binding?.apply {
            if (myindecator.size != DataPrevent.listData.lastIndex) {
                nextPic.setOnClickListener {
                    myViewPager.apply {
                        beginFakeDrag()
                        fakeDragBy(-10f)
                        endFakeDrag()
                    }
                }
            } else {
                nextPic.setOnClickListener {
                    myViewPager.apply {
                        beginFakeDrag()
                        fakeDragBy(10f)
                        endFakeDrag()
                    }
                }
            }

        }
    }
}
