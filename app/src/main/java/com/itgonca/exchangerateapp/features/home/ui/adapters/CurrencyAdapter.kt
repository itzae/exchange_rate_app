package com.itgonca.exchangerateapp.features.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.itgonca.domain.model.Historical
import com.itgonca.exchangerateapp.databinding.ItemCurrencyLayoutBinding
import com.itgonca.exchangerateapp.features.home.ui.viewholder.CurrencyViewHolder

class CurrencyAdapter : ListAdapter<Historical, CurrencyViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view =
            ItemCurrencyLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val itemCurrency = getItem(position)
        holder.bind(itemCurrency)
    }
}

private class DiffUtilCallback : DiffUtil.ItemCallback<Historical>() {
    override fun areItemsTheSame(oldItem: Historical, newItem: Historical): Boolean =
        oldItem.symbol == newItem.symbol


    override fun areContentsTheSame(oldItem: Historical, newItem: Historical): Boolean =
        oldItem == newItem
}