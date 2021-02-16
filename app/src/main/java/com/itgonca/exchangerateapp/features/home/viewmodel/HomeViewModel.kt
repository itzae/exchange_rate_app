package com.itgonca.exchangerateapp.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.domain.model.Historical
import com.itgonca.domain.usescases.GetHistoricalUsesCase
import com.itgonca.exchangerateapp.common.StateUI
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val historicalUsesCase: GetHistoricalUsesCase) :
    ViewModel() {

    private val _historicalData = MutableLiveData<StateUI<List<Historical>>>()

    val historicalData: LiveData<StateUI<List<Historical>>>
        get() = _historicalData

    fun getHistorical() {
        viewModelScope.launch {
            //h
            try {
                val data = historicalUsesCase.getHistorical()
                _historicalData.postValue(StateUI.Success(data))
            } catch (e: Exception) {
                _historicalData.postValue(StateUI.Error(type = 1,message = e.message))
            }
        }
    }
}