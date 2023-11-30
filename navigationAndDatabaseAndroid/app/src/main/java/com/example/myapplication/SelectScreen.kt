package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun SelectScreen(
    navController: NavHostController,
    currentRoute: String,
    viewModelFromActivity: SnippetViewModel,
    modifier: Modifier = Modifier,
) {
    val viewModelFromRoute: SnippetViewModel = viewModel()
    val uiStateFromRoute by viewModelFromRoute.uiState.collectAsState()
    val uiStateFromActivity by viewModelFromActivity.uiState.collectAsState()

    Column(Modifier.padding(vertical = 20.dp, horizontal = 10.dp).fillMaxSize()) {
        Row(Modifier.fillMaxWidth().weight(0.3f)) {
            OutlinedButton(
                modifier = Modifier.padding(5.dp).weight(0.5f).fillMaxHeight(),
                onClick = {
                    val newRoute = snippetDestinations[1].route
                    navController.navigate(newRoute) {
                        popUpTo(snippetDestinations[0].route) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                shape = RoundedCornerShape(10),
            ) {
                Text(text = snippetDestinations[1].route)
            }
            OutlinedButton(
                modifier = Modifier.padding(5.dp).weight(0.5f).fillMaxHeight(),
                onClick = {
                    val newRoute = snippetDestinations[2].route
                    navController.navigate(newRoute) {
                        popUpTo(snippetDestinations[0].route) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                shape = RoundedCornerShape(10),
            ) {
                Text(text = snippetDestinations[2].route)
            }
        }
        Row(Modifier.fillMaxWidth().weight(0.3f)) {
            OutlinedButton(
                modifier = Modifier.padding(5.dp).weight(0.5f).fillMaxHeight(),
                onClick = {
                    val newRoute = snippetDestinations[3].route
                    navController.navigate(newRoute) {
                        popUpTo(snippetDestinations[0].route) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                shape = RoundedCornerShape(10),
            ) {
                Text(text = snippetDestinations[3].route)
            }
            OutlinedButton(
                modifier = Modifier.padding(5.dp).weight(0.5f).fillMaxHeight(),
                onClick = {
                    val newRoute = snippetDestinations[4].route
                    navController.navigate(newRoute) {
                        popUpTo(snippetDestinations[0].route) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                shape = RoundedCornerShape(10),
            ) {
                Text(text = snippetDestinations[4].route)
            }
        }
        Row(Modifier.fillMaxWidth().weight(0.3f)) {
            OutlinedButton(
                modifier = Modifier.padding(5.dp).weight(0.5f).fillMaxHeight(),
                onClick = {
                    val newRoute = snippetDestinations[5].route
                    navController.navigate(newRoute) {
                        popUpTo(snippetDestinations[0].route) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                shape = RoundedCornerShape(10),
            ) {
                Text(text = snippetDestinations[5].route)
            }
            OutlinedButton(
                modifier = Modifier.padding(5.dp).weight(0.5f).fillMaxHeight(),
                onClick = {
                    val newRoute = snippetDestinations[6].route
                    navController.navigate(newRoute) {
                        popUpTo(snippetDestinations[0].route) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                shape = RoundedCornerShape(10),
            ) {
                Text(text = snippetDestinations[6].route)
            }
        }
    }

}