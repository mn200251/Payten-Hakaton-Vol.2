package com.example.mojkonobar.screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.MainActivity
import com.example.posaplikacija.stateholders.MojKonobarViewModel


@Composable
fun OrderScreen(
    viewModel: MojKonobarViewModel = viewModel(),
    modifier: Modifier = Modifier,
    mainActivity: MainActivity
)
{
    val uiState by viewModel.uiState.collectAsState()


    Column {

        Row (
            // modifier= modifier.background(Color.RE))

        ){
            Text(text = "My orders")
        }
        Spacer(modifier = modifier.height(20.dp))


    }


}