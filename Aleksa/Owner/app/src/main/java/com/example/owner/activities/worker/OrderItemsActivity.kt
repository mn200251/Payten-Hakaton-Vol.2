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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.owner.App
import com.example.owner.models.Order
import com.example.owner.ui.OrderItemsScreen
import com.example.owner.ui.getDate
import com.example.owner.ui.getPaytenRequestJson
import com.example.owner.ui.theme.OwnerTheme
import com.example.owner.ui.toRSD

class OrderItemsActivity : ComponentActivity() {
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
                    var order = (this.applicationContext as App).order!!
                    var fake by mutableStateOf(true)
                    if (fake) OrderItemsScreen(order = order, onPay = {
                        if (order.paymethod == Order.CARD) {
                            intent = Intent("com.payten.ecr.action")
                            intent.setPackage("com.payten.paytenapos")
                            intent.putExtra(
                                "ecrJson",
                                getPaytenRequestJson(
                                    toRSD(order.price),
                                    toRSD(order.tip ?: 0.0))
                                )
                            intent.putExtra("senderIntentFilter", "paytenreceive")
                            intent.putExtra("senderPackage", "com.example.owner.activities.worker")
                            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                            sendBroadcast(intent)
                        }
                    }, onServe = {
                        /*
                        To do update orderitem status to served,
                        locally and in the database
                         */
                        it.dateServed = getDate("2023-11-28 12:15:00")
                        order.itemsServed++
                        fake = false
                    }, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
