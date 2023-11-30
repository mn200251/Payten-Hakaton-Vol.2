package com.example.owner.activities.worker

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.owner.App
import com.example.owner.models.Order
import com.example.owner.ui.OrdersScreen
import com.example.owner.ui.theme.OwnerTheme

class WorkerActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
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
                    OrdersScreen(orders = Order.fakeOrders,
                        workerId = 0,
                        onTake = {
                             /*
                             * TO DO ->
                             * update state and workerId for order
                             * */
                        },
                        onDetails = {
                            (this.applicationContext as App).order = it
                            intent = Intent(this, OrderItemsActivity::class.java)
                            startActivity(intent)


                        }, modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
