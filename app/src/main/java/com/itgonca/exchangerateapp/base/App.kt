package com.itgonca.exchangerateapp.base

import android.app.Application
import com.itgonca.exchangerateapp.di.ApplicationComponent
import com.itgonca.exchangerateapp.di.DaggerApplicationComponent

class App : Application(){
    val appComponent : ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}