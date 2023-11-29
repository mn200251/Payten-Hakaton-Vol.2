package com.example.mojkonobar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.screens.LoginScreen
import com.example.mojkonobar.ui.theme.MojKonobarTheme
import com.example.posaplikacija.stateholders.MojKonobarViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MojKonobarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MojKonobar()
                }
            }
        }
    }
}


@Composable
fun MojKonobar()
{
    val viewModel: MojKonobarViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    LoginScreen(viewModel, modifier = Modifier)
    // RegisterScreen(modifier = Modifier)

}