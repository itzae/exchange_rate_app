package com.itgonca.exchangerateapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itgonca.exchangerateapp.R
import com.itgonca.exchangerateapp.common.dialogs.LoaderDialog
import com.itgonca.exchangerateapp.di.MainComponent
import com.itgonca.exchangerateapp.features.home.ui.HomeFragment

/**
 * This is the activity where the application fragments are loaded
 */
class MainActivity : BaseActivity() {

    lateinit var mainComponent:MainComponent
    private var dialogLoader: LoaderDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as App).appComponent.mainComponent().create()
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialogLoader = LoaderDialog.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.navHost,HomeFragment()).commit()
    }

    override fun showLoader() {
        dialogLoader?.show(supportFragmentManager, LoaderDialog.TAG)
    }

    override fun hideLoader() {
        dialogLoader?.dismiss()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}