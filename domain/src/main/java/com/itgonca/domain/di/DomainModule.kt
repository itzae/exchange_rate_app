package com.itgonca.domain.di

import com.itgonca.data.respository.HistoricalRepository
import com.itgonca.domain.usescases.GetHistoricalUsesCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun providerGetHistoricalUsesCase(historicalRepository: HistoricalRepository): GetHistoricalUsesCase =
        GetHistoricalUsesCase(historicalRepository)
}