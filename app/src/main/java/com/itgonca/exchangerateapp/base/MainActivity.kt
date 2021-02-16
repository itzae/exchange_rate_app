package com.itgonca.exchangerateapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itgonca.exchangerateapp.R
import com.itgonca.exchangerateapp.di.MainComponent
import com.itgonca.exchangerateapp.features.home.ui.HomeFragment

/**
 * This is the activity where the application fragments are loaded
 */
class MainActivity : AppCompatActivity() {

    lateinit var mainComponent:MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as App).appComponent.mainComponent().create()
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.navHost,HomeFragment()).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}