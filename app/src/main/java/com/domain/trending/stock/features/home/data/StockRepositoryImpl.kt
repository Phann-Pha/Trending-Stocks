package com.domain.trending.stock.features.home.data

import com.domain.trending.stock.R
import com.domain.trending.stock.features.home.domain.model.StockModel
import com.domain.trending.stock.features.home.domain.repository.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StockRepositoryImpl @Inject constructor() : StockRepository
{
    override suspend fun onGetStocks(): Flow<List<StockModel>> = flow {
        val stocks = listOf(
            StockModel(
                title = "Amzn",
                description = "Amazon, NC",
                icon = R.drawable.icon_amazon,
                value = "$89,08",
                rate = "0.12%"
            ),
            StockModel(
                title = "Spot",
                description = "Spotify, NC",
                icon = R.drawable.icon_spotify,
                value = "$76,24",
                rate = "0.12%"
            ),
            StockModel(
                title = "Nike",
                description = "Nike, NC",
                icon = R.drawable.icon_nike,
                value = "$103,08",
                rate = "8.78%"
            ),
        )
        emit(value = stocks)
    }

    override suspend fun onGetTrendingStocks(): Flow<List<StockModel>> = flow {
        val stocks = listOf(
            StockModel(
                title = "Apple",
                description = "Apple, Inc.",
                icon = R.drawable.icon_apple,
                value = "$132,843",
                rate = "8.78%"
            ),
            StockModel(
                title = "Amzn",
                description = "Amazon, NC",
                icon = R.drawable.icon_amazon,
                value = "$89,08",
                rate = "0.12%"
            ),
            StockModel(
                title = "Spot",
                description = "Spotify, NC",
                icon = R.drawable.icon_spotify,
                value = "$76,24",
                rate = "0.12%"
            ),
        )
        emit(value = stocks)
    }
}