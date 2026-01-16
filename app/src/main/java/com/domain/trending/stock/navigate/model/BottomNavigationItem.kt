package com.domain.trending.stock.navigate.model

import androidx.annotation.DrawableRes

data class BottomNavigationItem(
    val title: String,
    @param:DrawableRes val icon: Int,
    val route: String
)