package com.domain.trending.stock.features.home.domain.usecase

import com.domain.trending.stock.features.home.domain.model.StockModel
import com.domain.trending.stock.features.home.domain.repository.StockRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class QueryStocksUseCase @Inject constructor(private val repository: StockRepository)
{
    suspend fun invoke(): Flow<List<StockModel>> = repository.onGetStocks()
}