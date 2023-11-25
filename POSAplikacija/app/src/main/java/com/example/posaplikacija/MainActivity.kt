package com.example.posaplikacija

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.posaplikacija.ui.theme.POSAplikacijaTheme
import rs.etf.running.ui.elements.composables.RadioButtonWithText
import rs.etf.running.ui.elements.composables.Spinner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSAplikacijaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    POSApplication()
                }
            }
        }
    }
}


@Composable
fun POSApplication()
{
    var selected: Boolean = false
    var options = listOf<String>("Abc", "Xyz", "Pqr")
    Column()
    {
        Row()
        {

            RadioButtonWithText(text = "Test", selected = selected, onClick = { /*TODO*/ })
        }
        Row()
        {
            Spinner(value = "Random lista", onSelect = {}, options = options)
        }
    }




}