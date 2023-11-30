package com.example.owner.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.owner.models.Order
import com.example.owner.models.OrderItem

@Composable
fun OrdersScreen(orders: List<Order>, workerId: Int, onTake: (Order) -> Unit, onDetails: (Order) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(orders) {
            OrderButton(
                order = it,
                workerId = workerId,
                onTake = { onTake(it) },
                onDetails = { onDetails(it) },
                modifier = Modifier.fillMaxWidth().padding(10.dp).border(width = 3.dp, color = Color.Companion.Black, shape = MaterialTheme.shapes.medium))
        }
    }
}


@Composable
fun OrderItemsScreen(order: Order, onPay: () -> Unit, onServe: (OrderItem) -> Unit, modifier: Modifier = Modifier) {
    val items = order.getItems()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            Text(text = if (order.table == null) "Takeout for ${order.username}" else "Order for ${order.table}",
                style = MaterialTheme.typography.labelLarge,
                textDecoration = TextDecoration.Underline)
        }
        item {
            Text("Total price: $${order.price}", style = MaterialTheme.typography.bodyLarge)
        }
        if (order.paymethod != null) {
            if (order.tip != null) {
                item {
                    Text("Tip: $${order.tip}")
                }
            }
            val cash: Boolean = order.paymethod == Order.CASH
            item {
                Text("Payment method: ${if (cash) "Cash" else "Card"}")
            }
            item {
                OutlinedButton(onClick = onPay, shape = MaterialTheme.shapes.small) {
                    Text(if (cash) "Order paid" else "Proceed to payment", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
        item {Spacer(modifier = Modifier.height(10.dp)) }
        items(items) {
            OrderItemElement(orderItem = it, onServe = { onServe(it) })
        }

    }
}
