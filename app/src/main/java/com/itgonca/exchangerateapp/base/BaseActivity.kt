package com.itgonca.exchangerateapp.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    abstract fun showLoader()
    abstract fun hideLoader()
}