package com.example.owner.statistics

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.data.UiToolingDataApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class, UiToolingDataApi::class)
@Composable
fun ScreenWaiterSales(
    viewModelFromActivity: SnippetViewModel,
    dataViewModel: DataViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val viewModelFromRoute: SnippetViewModel = viewModel()

    var value by remember { mutableStateOf("") }
    val uiStateFromRoute by viewModelFromRoute.uiState.collectAsState()
    val uiStateFromActivity by viewModelFromActivity.uiState.collectAsState()

    val data by dataViewModel.avgPickupTime.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row( modifier = Modifier
                        .fillMaxWidth() ) {
                        Button(onClick = { navController.popBackStack() }, modifier = Modifier.weight(0.15f)) { Text(text = "<") }
                        Text(
                            text = "Waiter Sales",
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(0.7f)
                        )
                        Button(onClick = {}, modifier = Modifier.weight(0.15f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            )) {
                            Text(text = "")
                        }
                    }
                })
        }
    ) { pad->
        Column(modifier = modifier
            .padding(16.dp)
            .padding(pad)) {
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            SimpleDonutChart()
        }
    }
}
