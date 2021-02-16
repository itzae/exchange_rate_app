package com.itgonca.exchangerateapp.utils.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message:String){
    Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
}