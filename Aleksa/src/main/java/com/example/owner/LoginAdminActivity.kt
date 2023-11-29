package com.example.owner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.owner.ui.LoginScreen
import com.example.owner.ui.theme.OwnerTheme

class LoginAdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(
                        field1 = "Place ID",
                        field2 = "Password",
                        button = "Login",
                        onClick = { id, pass ->
                            /* TO DO
                            * Check database and remember current user (place)
                            * */
                            intent = Intent(this, AdminActivity::class.java)
                            startActivity(intent)
                        }, modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}