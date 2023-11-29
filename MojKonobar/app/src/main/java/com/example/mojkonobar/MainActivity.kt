package com.example.mojkonobar

import android.os.Bundle
import android.widget.ProgressBar
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
import com.example.mojkonobar.screens.HomeScreen
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
                    MojKonobar(this)
//                    val simpleProgressBar = findViewById<ProgressBar>(com.example.mojkonobar.R.id.simpleProgressBar)
//                    simpleProgressBar.progress = 50

                }
            }
        }
    }
}


@Composable
fun MojKonobar(mainActivity: MainActivity)
{
    val viewModel: MojKonobarViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    // LoginScreen(viewModel, modifier = Modifier)
    // RegisterScreen(modifier = Modifier)
    HomeScreen(viewModel, modifier = Modifier, mainActivity)

}