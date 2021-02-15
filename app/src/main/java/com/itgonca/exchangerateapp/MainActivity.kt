package com.itgonca.exchangerateapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itgonca.exchangerateapp.base.App
import com.itgonca.exchangerateapp.di.MainComponent
import com.itgonca.exchangerateapp.features.home.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent:MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as App).appComponent.mainComponent().create()
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.navHost,HomeFragment()).commit()
    }
}