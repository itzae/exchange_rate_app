package com.itgonca.exchangerateapp.features.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.domain.usescases.GetHistoricalUsesCase
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val historicalUsesCase: GetHistoricalUsesCase) : ViewModel() {
    fun getHistorical(){
        viewModelScope.launch {
            //h
            try {
                val data = historicalUsesCase.getHistorical()
                Log.i("DATA", "getHistorical: $data")

            }catch (e:Exception){
                Log.e("ERROR", "getHistorical: ${e.message}")
            }
        }
    }
}