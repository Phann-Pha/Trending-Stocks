package com.domain.trending.stock

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.domain.trending.stock.navigate.route.NavigationScreen
import com.domain.trending.stock.features.home.presentation.view.HomeScreenView
import com.domain.trending.stock.features.home.presentation.viewmodel.HomeScreenViewModel
import com.domain.trending.stock.navigate.view.BottomNavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppMainActivity : ComponentActivity()
{
    private val viewmodel: HomeScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        onChangeIconStatusBarColor()
        setContent { MainScreen() }
    }

    private fun onChangeIconStatusBarColor()
    {
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = true
        }
    }

    @Composable
    private fun MainScreen()
    {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavigationBarView(navController) }
        ) { paddings ->
            val graph = navController.createGraph(startDestination = NavigationScreen.HomeScreen.rout) {
                composable(route = NavigationScreen.HomeScreen.rout) {
                    HomeScreenView(viewmodel = viewmodel, paddings = paddings)
                }
                composable(route = NavigationScreen.StockScreen.rout) {
                    //
                }
                composable(route = NavigationScreen.ReportScreen.rout) {
                    //
                }
                composable(route = NavigationScreen.BalanceScreen.rout) {
                    //
                }
                composable(route = NavigationScreen.AccountScreen.rout) {
                    //
                }
            }
            NavHost(
                navController = navController,
                graph = graph,
                modifier = Modifier.padding(bottom = paddings.calculateBottomPadding())
            )
        }
    }
}