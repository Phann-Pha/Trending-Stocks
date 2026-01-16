package com.domain.trending.stock.features.home.presentation.components.dashboard

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.domain.trending.stock.R
import com.domain.trending.stock.features.home.presentation.components.dashboard.components.ButtonDashboardView
import com.domain.trending.stock.features.home.presentation.components.dashboard.components.GraphicContentView
import com.domain.trending.stock.features.home.presentation.components.dashboard.components.PortfolioContentView

@Preview(showBackground = true)
@Composable
fun DashboardContentView()
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
                .clip(shape = RoundedCornerShape(size = 24.dp))
                .border(
                    width = 1.5.dp,
                    color = colorResource(id = R.color.white_color),
                    shape = RoundedCornerShape(size = 24.dp)
                )
                .padding(all = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PortfolioContentView()
            Spacer(modifier = Modifier.height(height = 18.dp))
            GraphicContentView()
            Spacer(modifier = Modifier.height(height = 16.dp))
            ButtonDashboardView()
        }
    }
}