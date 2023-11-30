package com.example.owner.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.owner.ui.HomeScreen
import com.example.owner.ui.theme.OwnerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(
                        onLoginAdmin = {
                            intent = Intent(this, LoginAdminActivity::class.java);
                            startActivity(intent) },
                        onLoginWorker = {
                            intent = Intent(this, LoginWorkerActivity::class.java)
                            startActivity(intent)
                        },
                        onRegister = {
                            intent = Intent(this, RegisterActivity::class.java)
                            startActivity(intent)
                        }, modifier = Modifier.fillMaxSize()
                    )
                }

            }
        }
    }
}