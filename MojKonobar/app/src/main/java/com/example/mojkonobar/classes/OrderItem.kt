package com.example.mojkonobar.classes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mojkonobar.R
import com.example.posaplikacija.stateholders.places
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class OrderItem(
    val id: Int = 0,
    // val itemId: Int = 0,
    val orderId: Int = 0,
    val note: String? = null,
    val served: Int = 0,
    val name: String = "",
    val price: Double = 0.0,
    val imageLink: Int = R.drawable.mojito,
) {

}

