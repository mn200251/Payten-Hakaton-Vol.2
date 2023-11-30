package com.example.mojkonobar.screens

import android.net.Uri
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.posaplikacija.stateholders.MojKonobarViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(modifier: Modifier = Modifier, vm:MojKonobarViewModel= viewModel()) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {

            var inputUsername: String by rememberSaveable { mutableStateOf("") }
            var inputName: String by rememberSaveable { mutableStateOf("") }
            var inputLastName: String by rememberSaveable { mutableStateOf("") }
            var inputImage: Uri? by rememberSaveable { mutableStateOf(null) }
            var inputEmail: String by rememberSaveable { mutableStateOf("") }
            var inputPassword: String by rememberSaveable { mutableStateOf("") }

            Text(text = "Username:")
            OutlinedTextField(value = inputUsername, onValueChange = {inputUsername = it})
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Name:")
            OutlinedTextField(value = inputName, onValueChange = {inputName = it})
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Last name:")
            OutlinedTextField(value = inputLastName, onValueChange = {inputLastName = it})
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Email:")
            OutlinedTextField(value = inputEmail, onValueChange = {inputEmail = it})
            Spacer(modifier = Modifier.height(10.dp))

            // Text(text = "Image:")
            // ImageSelector(input = inputImage, onSelect = {inputImage = it}, Modifier.size(200.dp))
            // Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Password:")
            OutlinedTextField(value = inputPassword, onValueChange = {inputPassword = it})
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(onClick = {
                vm.changeScreen(1)
            }, shape = MaterialTheme.shapes.small) {
                Text(text = "Register", style = MaterialTheme.typography.labelMedium)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Already have an account?")
            OutlinedButton(
                onClick =
                {
                    vm.changeScreen(0)

                },
                shape = MaterialTheme.shapes.extraLarge) {
                Text(text = "Log in here", style = MaterialTheme.typography.labelLarge)
                }
        }
    }}