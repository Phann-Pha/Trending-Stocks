package com.domain.trending.stock.navigate.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.domain.trending.stock.R
import com.domain.trending.stock.navigate.model.BottomNavigationItem
import com.domain.trending.stock.navigate.route.NavigationScreen.HomeScreen

@Composable
fun BottomNavigationBarView(navController: NavHostController)
{
    val items = listOf(
        BottomNavigationItem(
            title = "",
            icon = R.drawable.icon_home,
            route = HomeScreen.rout
        ),
        BottomNavigationItem(
            title = "",
            icon = R.drawable.icon_stock,
            route = HomeScreen.rout
        ),
        BottomNavigationItem(
            title = "",
            icon = R.drawable.icon_report,
            route = HomeScreen.rout
        ),
        BottomNavigationItem(
            title = "",
            icon = R.drawable.icon_wallet,
            route = HomeScreen.rout
        ),
        BottomNavigationItem(
            title = "",
            icon = R.drawable.icon_person,
            route = HomeScreen.rout
        )
    )

    var selected by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = colorResource(id = R.color.transparent),
        contentColor = colorResource(id = R.color.transparent)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected == index,
                onClick = {
                    selected = index
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 2.dp)
                            .background(
                                color = if (index == selected)
                                {
                                    colorResource(id = R.color.blue_color)
                                }
                                else
                                {
                                    colorResource(id = R.color.transparent)
                                }
                            )
                            .padding(all = 24.dp),
                        tint = colorResource(id = if (index == selected) R.color.white_color else R.color.black_color),
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.blue_color),
                    indicatorColor = colorResource(id = R.color.transparent),
                    selectedTextColor = colorResource(id = R.color.transparent),
                    unselectedTextColor = colorResource(id = R.color.transparent),
                    unselectedIconColor = colorResource(id = R.color.black_color),
                    disabledIconColor = colorResource(id = R.color.transparent),
                    disabledTextColor = colorResource(id = R.color.transparent)
                )
            )
        }
    }
}