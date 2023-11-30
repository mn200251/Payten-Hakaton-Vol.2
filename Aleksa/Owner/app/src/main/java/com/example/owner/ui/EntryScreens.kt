package com.example.owner.ui


import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onLoginAdmin: () -> Unit,
    onLoginWorker: () -> Unit,
    onRegister: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LargeCenteredTextButton(text = "Admin Login", onClick = onLoginAdmin, modifier = Modifier.weight(1f))
        LargeCenteredTextButton(text = "Worker Login", onClick = onLoginWorker, modifier = Modifier.weight(1f))
        LargeCenteredTextButton(text = "Register", onClick = onRegister, modifier = Modifier.weight(1f))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(field1: String, field2: String, button: String, onClick: (String, String) -> Unit, modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        var input1: String by rememberSaveable { mutableStateOf("") }
        var input2: String by rememberSaveable { mutableStateOf("") }
        Text(text = field1 + ":")
        OutlinedTextField(value = input1, onValueChange = {input1 = it})
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = field2 + ":")
        OutlinedTextField(value = input2, onValueChange = {input2 = it})
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = {onClick(input1, input2)}, shape = MaterialTheme.shapes.small) {
            Text(text = button, style = MaterialTheme.typography.labelMedium)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(onClick: (String, String, String, Uri?, String, String, String) -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        var inputName: String by rememberSaveable { mutableStateOf("") }
        var inputLocation: String by rememberSaveable { mutableStateOf("") }
        var inputDescription: String by rememberSaveable { mutableStateOf("") }
        var inputImage: Uri? by rememberSaveable { mutableStateOf(null) }
        var inputID: String by rememberSaveable { mutableStateOf("") }
        var inputEmail: String by rememberSaveable { mutableStateOf("") }
        var inputPassword: String by rememberSaveable { mutableStateOf("") }
        Text(text = "Name:")
        OutlinedTextField(value = inputName, onValueChange = {inputName = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Location:")
        OutlinedTextField(value = inputLocation, onValueChange = {inputLocation = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Description:")
        OutlinedTextField(value = inputDescription, onValueChange = {inputDescription = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Image:")
        ImageSelector(input = inputImage, onSelect = {inputImage = it}, Modifier.size(200.dp))
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "PlaceID:")
        OutlinedTextField(value = inputID, onValueChange = {inputID = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Email:")
        OutlinedTextField(value = inputEmail, onValueChange = {inputEmail = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Password:")
        OutlinedTextField(value = inputPassword, onValueChange = {inputPassword = it})
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = {onClick(inputName, inputLocation, inputDescription, inputImage, inputID, inputEmail, inputPassword)}, shape = MaterialTheme.shapes.small) {
            Text(text = "Register", style = MaterialTheme.typography.labelMedium)
        }
    }
}