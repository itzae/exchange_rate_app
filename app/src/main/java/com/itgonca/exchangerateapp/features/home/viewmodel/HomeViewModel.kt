package com.itgonca.exchangerateapp.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.domain.usescases.GetHistoricalUsesCase
import kotlinx.coroutines.launch

class HomeViewModel(private val historicalUsesCase: GetHistoricalUsesCase) : ViewModel() {
    fun getHistorical(){
        viewModelScope.launch {
            historicalUsesCase.getHistorical()
        }
    }
}