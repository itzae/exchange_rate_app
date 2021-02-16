package com.itgonca.exchangerateapp.features.home.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.itgonca.domain.model.Historical
import com.itgonca.exchangerateapp.databinding.ItemCurrencyLayoutBinding

/**
 * This class is responsible for rendering the data obtained from the adapter in the UI
 **/

class CurrencyViewHolder(val binding: ItemCurrencyLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(itemCurrency: Historical) {
        binding.tvNameCurrency.text = itemCurrency.symbol
        binding.tvRateValueCurrency.text = itemCurrency.rate.toString()
    }
}