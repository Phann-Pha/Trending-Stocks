package com.domain.trending.stock.features.home.presentation.components.investment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.domain.trending.stock.features.home.presentation.components.investment.components.ItemInvestmentView
import com.domain.trending.stock.features.home.presentation.components.investment.components.TextInvestmentView
import com.domain.trending.stock.features.home.domain.model.StockModel

@Composable
fun InvestmentContentView(items: List<StockModel>)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            TextInvestmentView()
            Spacer(modifier = Modifier.height(height = 6.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                items(items = items, key = { it.title }) {
                    ItemInvestmentView(item = it)
                }
            }
        }
    }
}