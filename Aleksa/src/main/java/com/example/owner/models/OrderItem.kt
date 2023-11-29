package com.example.owner.models

class OrderItem(
    val id: Int = 0,
    val itemId: Int = 0,
    val orderId: Int = 0,
    val note: String? = null,
    val served: Int = 0,
    val name: String = "",
    val price: Double = 0.0
) {

}