package com.domain.trending.stock.navigate.route

sealed class NavigationScreen(val rout: String)
{
    object HomeScreen : NavigationScreen("home_screen")
    object StockScreen : NavigationScreen("stock_screen")
    object ReportScreen : NavigationScreen("report_screen")
    object BalanceScreen : NavigationScreen("balance_screen")
    object AccountScreen : NavigationScreen("account_screen")
}