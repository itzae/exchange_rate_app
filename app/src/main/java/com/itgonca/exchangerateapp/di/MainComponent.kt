package com.itgonca.exchangerateapp.di

import com.itgonca.exchangerateapp.MainActivity
import com.itgonca.exchangerateapp.features.home.ui.HomeFragment
import dagger.Subcomponent

@Subcomponent
interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create():MainComponent
    }
    fun inject(activity: MainActivity)
    fun inject(home: HomeFragment)
}