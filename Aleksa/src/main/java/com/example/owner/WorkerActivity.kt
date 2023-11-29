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
import com.example.owner.models.Order
import com.example.owner.ui.OrdersScreen
import com.example.owner.ui.theme.OwnerTheme

class WorkerActivity : ComponentActivity() {
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
                    TO DO: Get orders as state flow.
                     */
                    OrdersScreen(orders = Order.getFakeOrders(),
                        workerId = 0,
                        onTake = {
                             /*
                             * TO DO ->
                             * update state and workerId for order
                             * */
                        },
                        onDetails = {
                            intent = Intent(this, OrderItemsActivity::class.java)
                            startActivity(intent)
                            (this.applicationContext as App).order = it

                        }, modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
