package com.example.mojkonobar.screens

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.MainActivity
import com.example.mojkonobar.MojKonobar
import com.example.posaplikacija.stateholders.MojKonobarViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: MojKonobarViewModel = viewModel(), modifier: Modifier = Modifier, context: Context) {

    val uiState by viewModel.uiState.collectAsState()
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {

            Text(text = "Username")
            OutlinedTextField(value = uiState.usernameText, onValueChange = {viewModel.updateUsernameText(it)})
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Password")
            OutlinedTextField(value = uiState.passwordText, onValueChange = {viewModel.updatePasswordText(it)})
            Spacer(modifier = Modifier.height(10.dp))

            if (uiState.errorMessage != "")
            {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = uiState.errorMessage, style = MaterialTheme.typography.labelMedium,
                    color = Color.Red)
            }

            OutlinedButton(
                onClick =
                {
                    viewModel.tryLogin()
                    viewModel.changeScreen(0)
                },
                shape = MaterialTheme.shapes.small) {
                Text(text = "Log in", style = MaterialTheme.typography.labelMedium,)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Don't have an account?")
            OutlinedButton(
                onClick =
                {
                    viewModel.changeScreen(-1)

                },
                shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "Register here", style = MaterialTheme.typography.labelLarge)
                }
        }
    }}