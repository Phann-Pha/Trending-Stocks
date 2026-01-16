package com.domain.trending.stock.features.home.presentation.components.investment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.trending.stock.R
import com.domain.trending.stock.features.home.domain.model.StockModel

@Composable
fun ItemInvestmentView(item: StockModel)
{
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 3.dp, vertical = 3.dp)
            .clip(shape = RoundedCornerShape(size = 16.dp))
            .border(
                width = 1.5.dp,
                color = colorResource(id = R.color.white_color),
                shape = RoundedCornerShape(size = 16.dp)
            )
            .padding(all = 12.dp),
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            HeaderContentView(
                title = item.title,
                description = item.description,
                icon = item.icon
            )
            Spacer(modifier = Modifier.height(height = 18.dp))
            FooterContentView(
                value = item.value,
                rate = item.rate
            )
        }
    }
}

@Composable
private fun HeaderContentView(title: String, description: String, icon: Int)
{
    Box(modifier = Modifier.wrapContentSize()) {
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(shape = RoundedCornerShape(size = 24.dp))
                    .background(color = colorResource(id = R.color.dark_gray_color))
                    .padding(all = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(size = 24.dp)
                )
            }
            // ---
            Spacer(modifier = Modifier.width(width = 12.dp))
            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.black_color)
                )
                Spacer(modifier = Modifier.height(height = 4.dp))
                Text(
                    text = description,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.white_lower_color)
                )
            }
        }
    }
}

@Composable
private fun FooterContentView(value: String, rate: String)
{
    Box(modifier = Modifier.wrapContentSize()) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.black_color)
            )
            Spacer(modifier = Modifier.height(height = 4.dp))
            Row(
                modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_trend_up),
                    contentDescription = null,
                    tint = colorResource(id = R.color.green_color),
                    modifier = Modifier.size(size = 14.dp)
                )
                Spacer(modifier = Modifier.width(width = 4.dp))
                Text(
                    text = rate,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.green_color)
                )
            }
        }
    }
}