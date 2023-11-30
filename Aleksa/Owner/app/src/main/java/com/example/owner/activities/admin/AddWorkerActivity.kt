package com.example.owner.activities.admin

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
import com.example.owner.ui.AddWorkerScreen
import com.example.owner.ui.theme.OwnerTheme

class AddWorkerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddWorkerScreen(onClick = {
                        id, name, lastName, uri ->
                        /*
                        * TO DO -> check data and insert into data base
                        * id must be unique for this place
                        * image required??*/
                    }, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}