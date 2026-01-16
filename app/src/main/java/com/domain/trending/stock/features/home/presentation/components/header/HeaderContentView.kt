package com.domain.trending.stock.features.home.presentation.components.header

import android.view.MotionEvent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.trending.stock.R

@Composable
fun HeaderContentView(
    @DrawableRes image: Int,
    username: String,
    greeting: String,
    paddings: PaddingValues = PaddingValues()
)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp)
            .padding(top = paddings.calculateTopPadding())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileView(
                image = image,
                username = username,
                greeting = greeting
            )
            ActionHeaderView()
        }
    }
}

@Composable
private fun ProfileView(image: Int, username: String, greeting: String)
{
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "User Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(46.dp)
                    .clip(shape = CircleShape)
                    .border(
                        width = 1.2.dp,
                        color = colorResource(id = R.color.dark_gray_color),
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(width = 12.dp))
            Column(modifier = Modifier.wrapContentWidth()) {
                Text(
                    text = username,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.black_color)
                )
                Spacer(modifier = Modifier.height(height = 6.dp))
                Text(
                    text = greeting,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.white_lower_color)
                )
            }
        }
    }
}

@Composable
private fun ActionHeaderView()
{
    Box(modifier = Modifier.wrapContentSize()) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .clip(shape = RoundedCornerShape(size = 24.dp))
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.white_color),
                    shape = RoundedCornerShape(size = 24.dp)
                )
                .padding(all = 2.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonClickView(
                icon = R.drawable.icon_headset,
                backgroundColor = null,
                iconColor = R.color.black_color
            )
            Spacer(modifier = Modifier.width(width = 12.dp))
            ButtonClickView(
                icon = R.drawable.icon_bell,
                backgroundColor = R.color.white_color,
                iconColor = R.color.black_color
            )
        }
    }
}

@Composable
private fun ButtonClickView(
    @DrawableRes icon: Int,
    @ColorRes backgroundColor: Int?,
    @ColorRes iconColor: Int,
    clicked: () -> Unit = {}
)
{
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.9f else 1f)
    Box(
        modifier = Modifier
            .wrapContentSize()
            .scale(scale.value)
            .clip(shape = RoundedCornerShape(size = 24.dp))
            .background(color = colorResource(id = backgroundColor ?: R.color.transparent))
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
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Headset Icon",
            tint = colorResource(id = iconColor),
            modifier = Modifier.size(size = 24.dp)
        )
    }
}