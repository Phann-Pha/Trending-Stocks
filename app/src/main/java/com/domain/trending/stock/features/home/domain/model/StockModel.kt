package com.domain.trending.stock.features.home.domain.model

import androidx.annotation.DrawableRes

data class StockModel(
    val title: String = "",
    val description: String = "",
    @param:DrawableRes val icon: Int,
    val value: String = "",
    val rate: String = ""
)
