package com.domain.trending.stock.features.home.presentation.components.dashboard.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.trending.stock.R

@Composable
fun PortfolioContentView()
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BalancingView()
            CurrencyContentView()
        }
    }
}

@Composable
private fun BalancingView(balance: String = "$8,450.00")
{
    Box(modifier = Modifier.wrapContentSize()) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Portfolio",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.white_lower_color)
                )
                Spacer(modifier = Modifier.width(width = 8.dp))
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_eye_visibility),
                        contentDescription = null,
                        tint = colorResource(id = R.color.white_lower_color),
                        modifier = Modifier.size(size = 20.dp)
                    )
                }
            }
            // ---
            Spacer(modifier = Modifier.height(height = 8.dp))
            Box(modifier = Modifier.wrapContentSize()) {
                Text(
                    text = balance,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.black_color)
                )
            }
        }
    }
}

@Composable
private fun CurrencyContentView(first: String = "+ 00.400", second: String = " (+ 4.2%)")
{
    Box(modifier = Modifier.wrapContentSize()) {
        Column(
            modifier = Modifier.wrapContentSize(), horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(shape = RoundedCornerShape(size = 24.dp))
                    .border(
                        width = 1.5.dp,
                        color = colorResource(id = R.color.white_color),
                        shape = RoundedCornerShape(size = 24.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(all = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "USD",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.white_lower_color)
                    )
                }
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(all = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_arrow_right),
                        contentDescription = null,
                        tint = colorResource(id = R.color.black_color),
                        modifier = Modifier
                            .size(size = 14.dp)
                            .rotate(degrees = 90f)
                    )
                }
            }
            // ---
            Spacer(modifier = Modifier.height(height = 12.dp))
            Box(modifier = Modifier.wrapContentSize()) {
                Row(
                    modifier = Modifier.wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = first,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.white_lower_color)
                    )
                    Text(
                        text = second,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.green_color)
                    )
                }
            }
        }
    }
}