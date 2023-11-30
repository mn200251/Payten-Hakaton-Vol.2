package com.example.mojkonobar.classes

import java.time.LocalDate
import java.time.format.DateTimeFormatter



class Order(
    val id: Int = 0,
    val placeId: Int = 0,
    val username: String = "",
    val workerId: Int? = 0,
    val table: String = "",
    val status: Int = 0,
    val itemsServed: Int = 0,
    val paymethod: Int? = 0,
    val price: Double = 0.0,
    val tip: Double? = 0.0,
    val date: LocalDate = LocalDate.parse("2023-11-27", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
) {

    companion object {
        const val PENDING: Int = 0
        const val WAITING: Int = 1
        const val IDLE: Int = 2
        const val PAYMENT: Int = 3
        const val DONE: Int = 4
    }
    public fun getItems(): List<OrderItem> {
        /*TO DO
        *
        * Create a flow that queries the server periodically,
        * and convert it to a state flow.*/
        return listOf(
            OrderItem(
                note = "No salt please",
                served = 0,
                name = "Item1",
                price = 100.0
            ),
            OrderItem(
                note = null,
                served = 1,
                name = "Item2",
                price = 150.0
            )
        )
    }
}