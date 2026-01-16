package com.domain.trending.stock.features.home.presentation.components.dashboard.components

import android.view.MotionEvent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.trending.stock.R

@Composable
internal fun ButtonDashboardView()
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(weight = 1f)) {
                ButtonClickable(
                    text = "Deposit",
                    icon = R.drawable.icon_deposit,
                    iconColor = R.color.black_color,
                    textColor = R.color.black_color,
                    backgroundColor = R.color.dark_lighter_gray_color,
                    clicked = {}
                )
            }
            Spacer(modifier = Modifier.width(width = 16.dp))
            Column(modifier = Modifier.weight(weight = 1f)) {
                ButtonClickable(
                    text = "Withdraw",
                    icon = R.drawable.icon_wallet,
                    iconColor = R.color.white_color,
                    textColor = R.color.white_color,
                    backgroundColor = R.color.blue_color,
                    clicked = {}
                )
            }
        }
    }
}

@Composable
private fun ButtonClickable(
    text: String = "",
    @DrawableRes icon: Int,
    @ColorRes iconColor: Int,
    @ColorRes textColor: Int,
    @ColorRes backgroundColor: Int,
    clicked: () -> Unit = {}
)
{
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.9f else 1f)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .scale(scale.value)
            .clip(shape = RoundedCornerShape(size = 24.dp))
            .background(color = colorResource(id = backgroundColor))
            .pointerInteropFilter {
                when (it.action)
                {
                    MotionEvent.ACTION_DOWN ->
                    {
                        clicked.invoke()
                        selected.value = true
                    }

                    MotionEvent.ACTION_UP   ->
                    {
                        selected.value = false
                    }
                }; true
            }
            .padding(horizontal = 12.dp, vertical = 4.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(all = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Button Icon",
                tint = colorResource(id = iconColor),
                modifier = Modifier.size(size = 20.dp)
            )
        }
        // ---
        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 4.dp, end = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = textColor)
            )
        }
    }
}