package com.example.owner

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
import androidx.core.net.toUri
import com.example.owner.ui.UpdatePlaceInfoScreen
import com.example.owner.ui.theme.OwnerTheme

class UpdatePlaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*
                    TO DO -> Pass data base on current user
                    Retrieve image and save locally, to use URI
                     */
                    UpdatePlaceInfoScreen(
                        curName = "Default name",
                        curLocation = "Default location",
                        curDesription = "Default desc",
                        curImage = "".toUri(),
                        onUpdate = {
                            name, location, description, image ->
                            /*
                            * TO DO -> Updata data in the database and locally
                            *
                             */
                        }, modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}