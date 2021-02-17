package com.itgonca.exchangerateapp.di

import android.content.Context
import com.itgonca.data.di.DataModule
import com.itgonca.domain.di.DomainModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class, AppSubComponents::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun mainComponent(): MainComponent.Factory

}