package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.yml.charts.common.model.Point
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnippetApp(this)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnippetApp(context: Context) {
    val viewModelFromActivity: SnippetViewModel = viewModel()
    val dataViewModel: DataViewModel = viewModel()
    dataViewModel.setDay1()

    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    val currentRoute = currentDestination?.route ?: SelectScreen.route

    MyApplicationTheme {
        Scaffold {
            NavHost(
                navController = navController,
                startDestination = SelectScreen.route,
                modifier = Modifier.padding(it),
            ) {
                composable(route = SelectScreen.route) {
                    SelectScreen(navController = navController, currentRoute = SelectScreen.route,
                        viewModelFromActivity = viewModelFromActivity)
                }
                composable(route = snippetDestinations[1].route) {
                    ScreenVisitation(navController = navController,
                        viewModelFromActivity = viewModelFromActivity, dataViewModel = dataViewModel)
                }
                composable(route = snippetDestinations[2].route) {
                    ScreenItemSales(navController = navController,
                        viewModelFromActivity = viewModelFromActivity, dataViewModel = dataViewModel, context = context)
                }
                composable(route = snippetDestinations[3].route) {
                    ScreenAverageWaitTime(navController = navController,
                        viewModelFromActivity = viewModelFromActivity, dataViewModel = dataViewModel)
                }
                composable(route = snippetDestinations[4].route) {
                    ScreenTotalWaitTime(navController = navController,
                        viewModelFromActivity = viewModelFromActivity, dataViewModel = dataViewModel)
                }
                composable(route = snippetDestinations[5].route) {
                    ScreenWaiterSales(navController = navController,
                        viewModelFromActivity = viewModelFromActivity, dataViewModel = dataViewModel)
                }
                composable(route = snippetDestinations[6].route) {
                    ScreenAverageOrderPickupTime(navController = navController,
                        viewModelFromActivity = viewModelFromActivity, dataViewModel = dataViewModel)
                }
            }
        }
    }
}
