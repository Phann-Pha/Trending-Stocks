package com.domain.trending.stock.features.home.presentation.components.stock

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.domain.trending.stock.R
import com.domain.trending.stock.features.home.domain.model.StockModel
import com.domain.trending.stock.features.home.presentation.components.stock.components.ItemTrendingStockView
import com.domain.trending.stock.features.home.presentation.components.stock.components.TextTrendingStockView

@Composable
fun TrendingStockContentView(items: List<StockModel>)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp)
            .clip(shape = RoundedCornerShape(size = 16.dp))
            .border(
                width = 1.5.dp,
                color = colorResource(id = R.color.white_color),
                shape = RoundedCornerShape(size = 16.dp)
            )
            .padding(all = 12.dp),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            TextTrendingStockView()
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 205.dp)
                    .clip(shape = RoundedCornerShape(size = 16.dp))
                    .border(
                        width = 1.5.dp,
                        color = colorResource(id = R.color.transparent),
                        shape = RoundedCornerShape(size = 16.dp)
                    ),
                userScrollEnabled = false
            ) {
                items(items = items, key = { it.title }) {
                    ItemTrendingStockView(item = it)
                }
            }
        }
    }
}