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
import com.example.owner.ui.OrderItemsScreen
import com.example.owner.ui.getPaytenRequestJson
import com.example.owner.ui.theme.OwnerTheme
import com.example.owner.ui.toRSD

class OrderItemsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val order = (this.applicationContext as App).order!!
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OrderItemsScreen(order = order, onPay = {
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
                            intent.putExtra("senderPackage", "com.example.owner")
                            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                            sendBroadcast(intent)
                        }
                    }, onServe = {
                        /*
                        To do update orderitem status to served,
                        locally and in the database
                         */
                    }, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
