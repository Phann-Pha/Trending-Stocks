package com.domain.trending.stock.features.home.domain.repository

import com.domain.trending.stock.features.home.domain.model.StockModel
import kotlinx.coroutines.flow.Flow

interface StockRepository
{
    suspend fun onGetStocks(): Flow<List<StockModel>>

    suspend fun onGetTrendingStocks(): Flow<List<StockModel>>
}