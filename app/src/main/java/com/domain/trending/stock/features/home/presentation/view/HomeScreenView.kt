package com.domain.trending.stock.features.home.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.domain.trending.stock.R
import com.domain.trending.stock.features.home.presentation.components.dashboard.DashboardContentView
import com.domain.trending.stock.features.home.presentation.components.header.HeaderContentView
import com.domain.trending.stock.features.home.presentation.components.investment.InvestmentContentView
import com.domain.trending.stock.features.home.presentation.components.stock.TrendingStockContentView
import com.domain.trending.stock.features.home.presentation.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreenView(viewmodel: HomeScreenViewModel, paddings: PaddingValues = PaddingValues())
{
    val nestedScrollConnection = remember {
        object : NestedScrollConnection
        {
            // code here
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderContentView(
            image = R.drawable.profile_img,
            username = "Franklin Saint",
            greeting = "Good morning!",
            paddings = paddings
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(nestedScrollConnection)
        ) {
            item {
                Spacer(modifier = Modifier.height(height = 20.dp))
                DashboardContentView()
            }
            item {
                Spacer(modifier = Modifier.height(height = 20.dp))
                InvestmentContentView(items = viewmodel.stocks.value)
            }
            item {
                Spacer(modifier = Modifier.height(height = 20.dp))
                TrendingStockContentView(items = viewmodel.trendingStocks.value)
            }
            item { Box(modifier = Modifier.height(42.dp)) }
        }
    }
}
