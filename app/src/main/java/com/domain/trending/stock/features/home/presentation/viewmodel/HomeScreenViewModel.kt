package com.domain.trending.stock.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.trending.stock.features.home.domain.model.StockModel
import com.domain.trending.stock.features.home.domain.usecase.QueryStocksUseCase
import com.domain.trending.stock.features.home.domain.usecase.QueryTrendingStocksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val stockRepository: QueryStocksUseCase,
    private val trendingStockRepository: QueryTrendingStocksUseCase,
) : ViewModel()
{
    private val _stocks: MutableStateFlow<List<StockModel>> = MutableStateFlow(listOf())
    val stocks: StateFlow<List<StockModel>> = _stocks.asStateFlow()

    private val _trendingStocks: MutableStateFlow<List<StockModel>> = MutableStateFlow(listOf())
    val trendingStocks: StateFlow<List<StockModel>> = _trendingStocks.asStateFlow()

    init
    {
        onQueryStocks()
        onQueryTrendingStocks()
    }

    private fun onQueryStocks()
    {
        viewModelScope.launch {
            stockRepository.invoke().collect { result ->
                _stocks.emit(value = result)
            }
        }
    }

    private fun onQueryTrendingStocks()
    {
        viewModelScope.launch {
            stockRepository.invoke().collect { result ->
                _trendingStocks.emit(value = result)
            }
        }
    }


}