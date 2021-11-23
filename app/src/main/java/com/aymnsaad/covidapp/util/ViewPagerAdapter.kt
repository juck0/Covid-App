package com.aymnsaad.covidapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aymnsaad.covidapp.R
import com.aymnsaad.covidapp.data.domain.CovidPrevent
import com.aymnsaad.covidapp.databinding.PreventItemBinding

class ViewPagerAdapter(private val listData: List<CovidPrevent>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder =
        ViewPagerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.prevent_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val currentItem = listData[position]
        holder.binding.apply {
            textViewItem.text = currentItem.textTitle
            textShow.text = currentItem.textDescriptor
            imageViewItem.setImageResource(currentItem.image)
            imagePreventShow.setImageResource(currentItem.imagePreventShow)
        }
    }

    override fun getItemCount() = listData.size
    inner class ViewPagerHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = PreventItemBinding.bind(item)
    }
}
