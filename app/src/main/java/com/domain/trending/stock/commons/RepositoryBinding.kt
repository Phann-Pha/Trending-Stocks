package com.domain.trending.stock.commons

import com.domain.trending.stock.features.home.data.StockRepositoryImpl
import com.domain.trending.stock.features.home.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryBinding
{
    @Binds
    fun onBindStockRepository(impl: StockRepositoryImpl): StockRepository
}