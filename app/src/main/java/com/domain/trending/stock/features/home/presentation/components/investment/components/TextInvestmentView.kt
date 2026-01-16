package com.domain.trending.stock.features.home.presentation.components.investment.components

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.trending.stock.R

@Composable
fun TextInvestmentView(clicked: () -> Unit = {})
{
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.9f else 1f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.investment),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.black_color)
            )

            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .scale(scale.value)
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
                    .padding(all = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.view_all),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.black_color)
                )
            }
        }
    }
}