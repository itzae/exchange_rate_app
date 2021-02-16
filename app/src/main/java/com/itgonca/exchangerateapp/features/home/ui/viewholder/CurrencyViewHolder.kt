package com.itgonca.exchangerateapp.features.home.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.itgonca.domain.model.Historical
import com.itgonca.exchangerateapp.databinding.ItemCurrencyLayoutBinding

class CurrencyViewHolder(val binding: ItemCurrencyLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(itemCurrency: Historical) {
        binding.tvNameCurrency.text = itemCurrency.symbol
        binding.tvRateValueCurrency.text = itemCurrency.rate.toString()
    }
}