package com.example.mojkonobar.classes

import com.example.posaplikacija.stateholders.places
import java.time.LocalDate
import java.time.format.DateTimeFormatter



class Order(
    // val id: Int = 0,
    // val placeId: Int = 0,
    val place: Place = places[4],
    // val username: String = "",
    // val workerId: Int? = 0,
    // val table: String = "",
    val status: Int = 0,
    // val itemsServed: Int = 0,
    val paymethod: Int? = 0,
    val price: Double = 0.0,
    val tip: Double? = 0.0,
    val date: LocalDate = LocalDate.parse("2023-11-27", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    val items: List<OrderItem> = listOf<OrderItem>(),
) {

    companion object {
        const val PENDING: Int = 0
        const val WAITING: Int = 1
        const val IDLE: Int = 2
        const val PAYMENT: Int = 3
        const val DONE: Int = 4
    }
}

