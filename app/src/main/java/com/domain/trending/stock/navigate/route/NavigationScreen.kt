package com.domain.trending.stock.navigate.route

sealed class NavigationScreen(val rout: String)
{
    object HomeScreen : NavigationScreen("home_screen")
}